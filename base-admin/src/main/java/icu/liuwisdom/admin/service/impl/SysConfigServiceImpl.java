package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.mapper.SysConfigMapper;
import icu.liuwisdom.admin.entity.SysConfig;
import icu.liuwisdom.admin.query.SysConfigQuery;
import icu.liuwisdom.admin.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    @Resource
    SysConfigMapper sysConfigMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    @Override
    public PageInfo<SysConfig> pageData(SysConfigQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysConfig> wrapper = new LambdaQueryWrapper<SysConfig>()
                .eq(StringUtils.isNotEmpty(query.getLabel()), SysConfig::getLabel, query.getLabel())
                .eq(StringUtils.isNotEmpty(query.getType()), SysConfig::getType, query.getType())
                .eq(StringUtils.isNotEmpty(query.getDescription()), SysConfig::getDescription, query.getDescription())
                .orderByAsc(SysConfig::getSort);
        List<SysConfig> data = sysConfigMapper.selectList(wrapper);
        return PageInfo.of(data);
    }
}
