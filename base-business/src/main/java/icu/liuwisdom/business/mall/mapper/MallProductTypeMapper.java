package icu.liuwisdom.business.mall.mapper;

import icu.liuwisdom.business.mall.po.MallProductType;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商城 分类信息 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
public interface MallProductTypeMapper extends BaseMapper<MallProductType, MallProductTypeQuery, MallProductTypeVo> {
    @Override
    List<String> selectIds(@Param("query") MallProductTypeQuery query);

    @Override
    List<MallProductTypeVo> basePage(@Param("query") MallProductTypeQuery query, @Param("ids") List<String> ids);
}
