package icu.liuwisdom.business.mall.vo;

import icu.liuwisdom.business.mall.po.MallProductOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 商城 订单商品关联信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallProductOrderVo对象", description = "商城 订单商品关联信息")
public class MallProductOrderVo extends MallProductOrder implements Serializable {
    @ApiModelProperty("商品信息")
    private MallProductVo product;
}
