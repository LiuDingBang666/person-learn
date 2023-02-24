package icu.liuwisdom.business.mall.service;

import icu.liuwisdom.business.mall.dto.MallUserBalanceDto;
import icu.liuwisdom.business.mall.po.MallUserBalance;
import icu.liuwisdom.business.mall.query.MallUserBalanceQuery;
import icu.liuwisdom.business.mall.vo.MallUserBalanceVo;
import icu.liuwisdom.core.service.BaseService;

/**
 * <p>
 * 商城 用户余额信息 服务类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
public interface MallUserBalanceService extends BaseService<MallUserBalance, MallUserBalanceQuery, MallUserBalanceVo> {

    Boolean save(MallUserBalanceDto dto);

    Boolean updateById(MallUserBalanceDto dto);

    Boolean recharge(MallUserBalanceDto dto);

    Boolean reduce(MallUserBalanceDto dto);
}
