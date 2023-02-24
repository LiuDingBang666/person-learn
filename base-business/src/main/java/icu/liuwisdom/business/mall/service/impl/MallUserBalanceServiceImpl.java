package icu.liuwisdom.business.mall.service.impl;

import icu.liuwisdom.business.mall.dto.MallUserBalanceDto;
import icu.liuwisdom.business.mall.mapper.MallUserBalanceMapper;
import icu.liuwisdom.business.mall.po.MallUserBalance;
import icu.liuwisdom.business.mall.query.MallUserBalanceQuery;
import icu.liuwisdom.business.mall.service.MallUserBalanceService;
import icu.liuwisdom.business.mall.vo.MallUserBalanceVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商城 用户余额信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallUserBalanceServiceImpl extends BaseServiceImpl<MallUserBalanceMapper, MallUserBalance, MallUserBalanceQuery, MallUserBalanceVo> implements MallUserBalanceService {

    @Override
    public Boolean save(MallUserBalanceDto dto) {
        return null;
    }

    @Override
    public Boolean updateById(MallUserBalanceDto dto) {
        return null;
    }

    @Override
    public Boolean recharge(MallUserBalanceDto dto) {
        return null;
    }

    @Override
    public Boolean reduce(MallUserBalanceDto dto) {
        return null;
    }
}
