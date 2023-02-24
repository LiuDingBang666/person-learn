package icu.liuwisdom.business.mall.service.impl;
import icu.liuwisdom.business.mall.service.MallOrderProcessService;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import icu.liuwisdom.business.mall.po.MallOrderProcess;
import icu.liuwisdom.business.mall.query.MallOrderProcessQuery;
import icu.liuwisdom.business.mall.vo.MallOrderProcessVo;
import icu.liuwisdom.business.mall.mapper.MallOrderProcessMapper;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 商城 订单进展信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallOrderProcessServiceImpl extends BaseServiceImpl<MallOrderProcessMapper, MallOrderProcess, MallOrderProcessQuery, MallOrderProcessVo> implements MallOrderProcessService {

}
