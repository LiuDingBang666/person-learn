package icu.liuwisdom.business.mall.service.impl;

import icu.liuwisdom.business.mall.mapper.MallProductOrderMapper;
import icu.liuwisdom.business.mall.po.MallProductOrder;
import icu.liuwisdom.business.mall.query.MallProductOrderQuery;
import icu.liuwisdom.business.mall.service.MallProductOrderService;
import icu.liuwisdom.business.mall.vo.MallProductOrderVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商城 订单商品关联信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallProductOrderServiceImpl extends BaseServiceImpl<MallProductOrderMapper, MallProductOrder, MallProductOrderQuery, MallProductOrderVo> implements MallProductOrderService {

}
