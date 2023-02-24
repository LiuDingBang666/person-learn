package icu.liuwisdom.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysNoticeDto;
import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.entity.SysNoticeRange;
import icu.liuwisdom.admin.enums.SysNoticeEnum;
import icu.liuwisdom.admin.mapper.SysNoticeMapper;
import icu.liuwisdom.admin.mapper.SysNoticeRangeMapper;
import icu.liuwisdom.admin.query.SysNoticeQuery;
import icu.liuwisdom.admin.service.SysNoticeRangeService;
import icu.liuwisdom.admin.service.SysNoticeService;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.admin.vo.SysNoticeVo;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Service
public class SysNoticeServiceImplImpl extends BaseServiceImpl<SysNoticeMapper, SysNotice, SysNoticeQuery, SysNoticeVo> implements SysNoticeService {
    @Resource
    SysNoticeMapper mapper;
    @Resource
    SysNoticeRangeService sysNoticeRangeService;

    @Resource
    SysNoticeRangeMapper rangeMapper;

    @Override
    public boolean publish(String id) {
        val data = this.getById(id);
        checkPo(data);
        if (!data.getStatus().equals(SysNoticeEnum.SAVE.getVALUE()) && !data.getStatus().equals(SysNoticeEnum.DISABLED.getVALUE())) {
            throw new BusinessException("公告不为暂存或禁用状态，无法发布");
        }
        data.setPublishTime(LocalDateTime.now());
        data.setStatus(SysNoticeEnum.PUBLISH.getVALUE());
        this.updateById(data);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(String id) {
        sysNoticeRangeService.deleteByNoticeId(id);
        return super.removeById(id);
    }

    @Override
    public PageInfo<SysNoticeVo> page(SysNoticeQuery query) {
        query.setStatus(2);
        val user = UserUtils.getUser();
        val dept = user.getDept();
        // 指定用户、指定部门
        val ids = rangeMapper.selectList(new LambdaQueryWrapper<SysNoticeRange>().eq(SysNoticeRange::getFkUserId, user.getId())).stream().map(val -> val.getFkNoticeId()).collect(Collectors.toSet());
        if (Objects.nonNull(dept)) {
            ids.addAll(rangeMapper.selectList(new LambdaQueryWrapper<SysNoticeRange>().eq(SysNoticeRange::getFkDeptId, dept.getId())).stream().map(val -> val.getFkNoticeId()).collect(Collectors.toSet()));
        }
        // 全部部门
        if (Objects.nonNull(dept)) {
            ids.addAll(mapper.selectList(new LambdaQueryWrapper<SysNotice>().eq(SysNotice::getNoticeRange, 3)).stream().map(SysNotice::getId).collect(Collectors.toSet()));
        }
        // 全部
        ids.addAll(this.list(new LambdaQueryWrapper<SysNotice>().eq(SysNotice::getNoticeRange, 1)).stream().map(SysNotice::getId).collect(Collectors.toSet()));
        query.setIds(ids.stream().collect(Collectors.toList()));
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return PageInfo.of(mapper.page(query));
    }

    @Override
    public <C extends SysNotice> void checkPo(C data) {
        if (Objects.isNull(data)) {
            throw new BusinessException("公告不存在");
        }
    }

    @Override
    public boolean disabled(String id) {
        val data = this.getById(id);
        checkPo(data);
        if (!data.getStatus().equals(SysNoticeEnum.PUBLISH.getVALUE())) {
            throw new BusinessException("公告不为发布状态，无法发布");
        }
        if (StringUtils.isNotEmpty(data.getCreateBy()) && !data.getCreateBy().equals(UserUtils.getUser().getId())) {
            throw new BusinessException("你不能修改其他用户的通知信息");
        }
        data.setStatus(SysNoticeEnum.DISABLED.getVALUE());
        this.updateById(data);
        return true;
    }

    @Override
    public PageInfo<SysNoticeVo> multiListPage(SysNoticeQuery query) {
        return super.multiListPage(query);
    }

    @Override
    public SysNoticeVo getById(String id, boolean update) {
        // 更新阅读量
        if (update) {
            val po = this.getById(id);
            po.setReadNum(null == po.getReadNum() ? 0 : po.getReadNum() + 1);
            this.updateById(po);
        }
        return mapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysNotice save(SysNoticeDto dto) {
        SysNotice po = new SysNotice();
        BeanUtil.copyProperties(dto, po);
        this.checkPo(po);
        this.save(po);
        val ranges = dto.getRanges();
        insertRange(po, ranges);
        return po;
    }

    /**
     * 新增公告范围信息
     *
     * @param po
     * @param ranges
     * @author LDB
     * @date 2022-12-06
     **/
    public void insertRange(SysNotice po, List<SysNoticeRange> ranges) {
        if (Objects.nonNull(ranges) && !ranges.isEmpty()) {
            sysNoticeRangeService.saveBatch(ranges.stream().peek(val -> {
                val.setFkNoticeId(po.getId());
                val.setNoticeRange(po.getNoticeRange());
            }).collect(Collectors.toList()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysNotice updateById(SysNoticeDto dto) {
        SysNotice po = new SysNotice();
        BeanUtil.copyProperties(dto, po);
        this.checkPo(po);
        this.updateById(po);
        sysNoticeRangeService.deleteByNoticeId(po.getId());
        insertRange(po, dto.getRanges());
        return po;
    }
}
