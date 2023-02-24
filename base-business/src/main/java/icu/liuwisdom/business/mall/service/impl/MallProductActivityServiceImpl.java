package icu.liuwisdom.business.mall.service.impl;

import icu.liuwisdom.business.mall.mapper.MallProductActivityMapper;
import icu.liuwisdom.business.mall.po.MallProductActivity;
import icu.liuwisdom.business.mall.query.MallProductActivityQuery;
import icu.liuwisdom.business.mall.service.MallProductActivityService;
import icu.liuwisdom.business.mall.vo.MallProductActivityVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商城 产品活动 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallProductActivityServiceImpl extends BaseServiceImpl<MallProductActivityMapper, MallProductActivity, MallProductActivityQuery, MallProductActivityVo> implements MallProductActivityService {

}
