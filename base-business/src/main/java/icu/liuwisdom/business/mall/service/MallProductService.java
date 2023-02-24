package icu.liuwisdom.business.mall.service;

import icu.liuwisdom.business.mall.po.MallProduct;
import icu.liuwisdom.business.mall.query.MallProductQuery;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.business.mall.vo.MallProductVo;
import icu.liuwisdom.core.service.BaseService;

import java.util.List;

/**
 * <p>
 * 商城 产品信息 服务类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
public interface MallProductService extends BaseService<MallProduct, MallProductQuery, MallProductVo> {

    /**
     * 查询商品树
     *
     * @param query 查询类
     * @return java.util.List<icu.liuwisdom.business.mall.vo.MallProductTypeVo>
     * @author LDB
     * @date 2023-01-27
     **/
    List<MallProductTypeVo> shopTree(MallProductTypeQuery query);

    /**
     * 更新商品状态
     *
     * @param ids   主键
     * @param state 状态值
     * @return java.lang.Boolean
     * @author LDB
     * @date 2023-01-27
     **/
    Boolean updateState(List<String> ids, Integer state);
}
