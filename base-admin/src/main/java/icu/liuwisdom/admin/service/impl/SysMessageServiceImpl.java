package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.mapper.SysMessageMapper;
import icu.liuwisdom.admin.query.SysMessageQuery;
import icu.liuwisdom.admin.service.SysMessageService;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.core.exception.BusinessException;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 消息表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements SysMessageService {
    @Resource
    SysMessageMapper mapper;

    @Override
    public Boolean read(String id) {
        val po = this.getById(id);
        if (Objects.isNull(po)) {
            throw new BusinessException("消息不存在");
        }
        if (!UserUtils.getUser().getId().equals(po.getFkUserId())) {
            throw new BusinessException("您不能修改其他人的消息");
        }
        po.setStatus(2);
        this.updateById(po);
        return true;
    }

    @Override
    public Boolean handed(String id) {
        val po = this.getById(id);
        if (Objects.isNull(po)) {
            throw new BusinessException("消息不存在");
        }
        if (!UserUtils.getUser().getId().equals(po.getFkUserId())) {
            throw new BusinessException("您不能修改其他人的消息");
        }
        po.setStatus(3);
        this.updateById(po);
        return true;
    }

    @Override
    public PageInfo<SysMessage> pageData(SysMessageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        val data = mapper.selectList(new LambdaQueryWrapper<SysMessage>()
                .eq(StringUtils.isNotEmpty(query.getFkUserId()), SysMessage::getFkUserId, query.getFkUserId())
                .eq(Objects.nonNull(query.getStatus()), SysMessage::getStatus, query.getStatus())
                .eq(StringUtils.isNotEmpty(query.getType()), SysMessage::getType, query.getType())
        );
        return PageInfo.of(data);
    }
}
