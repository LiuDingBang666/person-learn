package icu.liuwisdom.business.mall.query;
import icu.liuwisdom.core.page.PageRequest;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 用户余额流水信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallUserBalanceWaterQuery对象" , description = "商城 用户余额流水信息")
public class MallUserBalanceWaterQuery extends PageRequest implements Serializable {

    @ApiModelProperty("用户id")
    private String fkUserId;

    @ApiModelProperty("时间")
    private LocalDate waterDate;

    @ApiModelProperty("余额")
    private BigDecimal balance;

    @ApiModelProperty("余额类型 0=积分 1=余额")
    private Integer type;

    @ApiModelProperty("流水类型 0=充值 1=扣除")
    private Integer waterType;

    @ApiModelProperty("充值方式 0=系统内部 1=微信 2=支付宝 3=信用卡 4=其他")
    private Integer rechargeType;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
