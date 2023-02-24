package icu.liuwisdom.business.mall.vo;

import icu.liuwisdom.business.mall.po.MallOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商城 订单信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallOrderVo对象", description = "商城 订单信息")
public class MallOrderVo extends MallOrder implements Serializable {

    @ApiModelProperty("订单商品信息")
    private MallProductOrderVo productOrders;

    @ApiModelProperty("订单进展信息")
    private List<MallOrderProcessVo> processInfo;
}
