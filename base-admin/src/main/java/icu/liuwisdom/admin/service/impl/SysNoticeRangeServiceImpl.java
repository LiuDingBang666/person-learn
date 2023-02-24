package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.liuwisdom.admin.entity.SysNoticeRange;
import icu.liuwisdom.admin.mapper.SysNoticeRangeMapper;
import icu.liuwisdom.admin.service.SysNoticeRangeService;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 通知范围表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Service
public class SysNoticeRangeServiceImpl extends ServiceImpl<SysNoticeRangeMapper, SysNoticeRange> implements SysNoticeRangeService {
    @Resource
    SysNoticeRangeMapper mapper;

    @Override
    public Boolean deleteByNoticeId(String id) {
        val res = mapper.delete(new LambdaQueryWrapper<SysNoticeRange>().eq(SysNoticeRange::getFkNoticeId, id));
        return res > 0;
    }
}
