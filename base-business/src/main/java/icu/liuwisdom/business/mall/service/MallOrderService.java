package icu.liuwisdom.business.mall.service;

import icu.liuwisdom.business.mall.dto.MallOrderDto;
import icu.liuwisdom.business.mall.po.MallOrder;
import icu.liuwisdom.business.mall.query.MallOrderQuery;
import icu.liuwisdom.business.mall.vo.MallOrderVo;
import icu.liuwisdom.core.service.BaseService;
/**
 * <p>
 * 商城 订单信息 服务类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
public interface MallOrderService extends BaseService<MallOrder, MallOrderQuery, MallOrderVo> {

    Boolean save(MallOrderDto dto);

    Boolean updateById(MallOrderDto dto);

    MallOrderVo getById(String id);
}
