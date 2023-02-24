package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysDict;
import icu.liuwisdom.admin.mapper.SysDictMapper;
import icu.liuwisdom.admin.query.SysDictQuery;
import icu.liuwisdom.admin.service.SysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    @Resource
    SysDictMapper sysDictMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    @Override
    public PageInfo<SysDict> pageData(SysDictQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysDict> wrapper = new LambdaQueryWrapper<SysDict>()
                .eq(StringUtils.isNotEmpty(query.getLabel()), SysDict::getLabel, query.getLabel())
                .eq(StringUtils.isNotEmpty(query.getType()), SysDict::getLabel, query.getType())
                .eq(StringUtils.isNotEmpty(query.getDescription()), SysDict::getLabel, query.getDescription())
                .orderByAsc(SysDict::getSort);
        List<SysDict> data = sysDictMapper.selectList(wrapper);
        return PageInfo.of(data);
    }
}
