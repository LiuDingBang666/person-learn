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
 * 商城 用户余额信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallUserBalanceDto对象", description = "商城 用户余额信息")
public class MallUserBalanceDto extends BaseModel implements Serializable {

    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty(message = "用户id不能为空")
    private String fkUserId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty(value = "余额", required = true)
    @NotEmpty(message = "余额不能为空")
    private BigDecimal balance;

    @ApiModelProperty(value = "余额类型 0=积分 1=余额", required = true)
    @NotNull(message = "余额类型不能为空")
    private Integer type;

}
