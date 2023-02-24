package icu.liuwisdom.business.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.liuwisdom.business.mall.enums.ProductEnum;
import icu.liuwisdom.business.mall.mapper.MallProductMapper;
import icu.liuwisdom.business.mall.po.MallProduct;
import icu.liuwisdom.business.mall.po.MallProductType;
import icu.liuwisdom.business.mall.query.MallProductQuery;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.service.MallProductService;
import icu.liuwisdom.business.mall.service.MallProductTypeService;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.business.mall.vo.MallProductVo;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import icu.liuwisdom.core.utils.tree.TreeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商城 产品信息 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Service
public class MallProductServiceImpl extends BaseServiceImpl<MallProductMapper, MallProduct, MallProductQuery, MallProductVo> implements MallProductService {
    @Resource
    MallProductTypeService typeService;

    @Override
    public boolean updateById(MallProduct entity) {
        initInfo(entity);
        return super.updateById(entity);
    }

    /**
     * 初始化信息
     *
     * @param entity
     * @author LDB
     * @date 2023-01-27
     **/
    private void initInfo(MallProduct entity) {
        MallProductType type = typeService.getById(entity.getFkTypeId());
        entity.setTypeName(type.getName());

    }

    @Override
    public boolean save(MallProduct entity) {
        initInfo(entity);
        return super.save(entity);
    }

    @Override
    public LambdaQueryWrapper<MallProduct> wrapper(MallProductQuery query) {
        return super.wrapper(query)
                .eq(StringUtils.isNotBlank(query.getFkTypeId()), MallProduct::getFkTypeId, query.getFkTypeId())
                .like(StringUtils.isNotBlank(query.getTypeName()), MallProduct::getTypeName, query.getTypeName())
                .eq(StringUtils.isNotBlank(query.getFkDeptId()), MallProduct::getFkDeptId, query.getFkDeptId())
                .like(StringUtils.isNotBlank(query.getDeptName()), MallProduct::getDeptName, query.getDeptName())
                .like(StringUtils.isNotBlank(query.getName()), MallProduct::getName, query.getName())
                .eq(null != query.getStatus(), MallProduct::getStatus, query.getStatus())
                .eq(null != query.getIsCreditsExchange(), MallProduct::getIsCreditsExchange, query.getIsCreditsExchange())
                .orderByAsc(MallProduct::getSort);
    }

    /**
     * 根据不同的分类筛选不同的商品
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.business.mall.vo.MallProductTypeVo>
     * @author LDB
     * @date 2023-01-27
     **/
    @Override
    public List<MallProductTypeVo> shopTree(MallProductTypeQuery query) {
        return TreeUtils.buildVo(typeService.multiListPage(query).getList());
    }

    @Override
    public Boolean updateState(List<String> ids, Integer state) {
        // 获取需要修改的列表
        List<MallProduct> list = this.list(new LambdaQueryWrapper<MallProduct>().in(MallProduct::getId, ids));
        list.stream().peek(val -> checkState(val.getStatus(), state)).count();
        boolean result = update(new UpdateWrapper<MallProduct>().lambda()
                .in(MallProduct::getId, ids)
                .set(MallProduct::getStatus, state));
        return result;
    }


    /**
     * 检查状态值
     *
     * @param old   原值
     * @param state 现值
     * @author LDB
     * @date 2023-01-27
     **/
    private void checkState(Integer old, Integer state) {
        // 状态验证
        switch (state) {
            // 上架
            case 0:
                if (!old.equals(ProductEnum.SOLD_OUT.getValue())) {
                    throw new BusinessException("只有下架状态下才能修改状态为上架");
                }
                break;
            // 下架
            case 1:
                if (!old.equals(ProductEnum.SOLD_FLOWERS.getValue()) || !old.equals(ProductEnum.Gallery.getValue())) {
                    throw new BusinessException("只有已上架或售馨状态下才能修改状态为下架");
                }
                break;
            case 2:
                // 售馨
                if (!old.equals(ProductEnum.Gallery.getValue())) {
                    throw new BusinessException("只有上架状态才能修改状态为已售馨");
                }
                break;
            default:
                throw new BusinessException("状态值有误");
        }
    }
}
