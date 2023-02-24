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
@ApiModel(value = "MallProductOrderDto对象", description = "商城 订单商品关联信息")
public class MallProductOrderDto extends BaseModel implements Serializable {

    @ApiModelProperty("订单id")
    private String fkOrderId;

    @ApiModelProperty(value = "商品id", required = true)
    @NotEmpty(message = "商品不能为空")
    private String fkProductId;

    @ApiModelProperty(value = "购买数量", required = true)
    @NotNull(message = "购买数量不能为空")
    private Integer nums;

    @ApiModelProperty("单笔总金额")
    private BigDecimal total;

}
