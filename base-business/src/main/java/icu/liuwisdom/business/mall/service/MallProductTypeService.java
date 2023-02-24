package icu.liuwisdom.business.mall.service;

import icu.liuwisdom.business.mall.po.MallProductType;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.service.BaseService;

import java.util.List;

/**
 * <p>
 * 商城 分类信息 服务类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
public interface MallProductTypeService extends BaseService<MallProductType, MallProductTypeQuery, MallProductTypeVo> {
    /**
     * 分类树
     *
     * @param query
     * @return java.util.List<icu.liuwisdom.business.mall.vo.MallProductTypeVo>
     * @author LDB
     * @date 2023-01-27
     **/
    List<MallProductTypeVo> tree(MallProductTypeQuery query);
}
