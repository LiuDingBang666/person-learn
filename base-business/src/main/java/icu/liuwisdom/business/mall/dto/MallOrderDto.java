package icu.liuwisdom.business.mall.dto;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "MallOrderDto对象", description = "商城 订单信息")
public class MallOrderDto extends BaseModel implements Serializable {

    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty(message = "用户id不能为空")
    private String fkUserId;

    @ApiModelProperty(value = "订单状态 0=待支付 1=已取消 2=已支付 3=已收货 4=已退款", required = true)
    @NotNull(message = "订单状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "订单类型 0=积分订单 1=余额订单", required = true)
    @NotNull(message = "订单类型不能为空")
    private Integer type;

    @ApiModelProperty("支付方式 0=系统内部 1=微信 2=支付宝 3=信用卡 4=其他")
    private Integer payType;

    @ApiModelProperty(value = "收货人", required = true)
    @NotEmpty(message = "收货人不能为空")
    private String consignee;

    @ApiModelProperty(value = "收货人手机号", required = true)
    @NotEmpty(message = "收货人手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "收货地址", required = true)
    @NotEmpty(message = "收货地址不能为空")
    private String address;

    @ApiModelProperty("总金额")
    private BigDecimal total;

    @ApiModelProperty(value = "商品信息", required = true)
    @NotEmpty(message = "商品信息不能为空")
    private List<MallProductOrderDto> orderProducts;

}
