package icu.liuwisdom.business.mall.service.impl;

import icu.liuwisdom.business.mall.dto.MallOrderDto;
import icu.liuwisdom.business.mall.mapper.MallOrderMapper;
import icu.liuwisdom.business.mall.po.MallOrder;
import icu.liuwisdom.business.mall.query.MallOrderQuery;
import icu.liuwisdom.business.mall.service.MallOrderService;
import icu.liuwisdom.business.mall.vo.MallOrderVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商城 订单信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallOrderServiceImpl extends BaseServiceImpl<MallOrderMapper, MallOrder, MallOrderQuery, MallOrderVo> implements MallOrderService {

    @Override
    public Boolean save(MallOrderDto dto) {
        return null;
    }

    @Override
    public Boolean updateById(MallOrderDto dto) {
        return null;
    }

    @Override
    public MallOrderVo getById(String id) {
        return null;
    }
}
