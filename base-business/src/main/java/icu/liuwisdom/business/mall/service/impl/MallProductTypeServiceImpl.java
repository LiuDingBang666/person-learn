package icu.liuwisdom.business.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import icu.liuwisdom.business.mall.mapper.MallProductTypeMapper;
import icu.liuwisdom.business.mall.po.MallProductType;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.service.MallProductTypeService;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import icu.liuwisdom.core.utils.tree.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商城 分类信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallProductTypeServiceImpl extends BaseServiceImpl<MallProductTypeMapper, MallProductType, MallProductTypeQuery, MallProductTypeVo> implements MallProductTypeService {

    @Override
    public LambdaQueryWrapper<MallProductType> wrapper(MallProductTypeQuery query) {
        return super.wrapper(query)
                .like(StringUtils.isNotBlank(query.getName()), MallProductType::getName, query.getName())
                .like(StringUtils.isNotBlank(query.getDescription()), MallProductType::getDescription, query.getDescription())
                .like(StringUtils.isNotBlank(query.getDeptName()), MallProductType::getDeptName, query.getDeptName())
                .eq(StringUtils.isNotBlank(query.getFkDeptId()), MallProductType::getFkDeptId, query.getFkDeptId())
                .orderByAsc(MallProductType::getSort);
    }

    @Override
    public List<MallProductTypeVo> tree(MallProductTypeQuery query) {
        return TreeUtils.build(list(wrapper(query)));
    }
}
