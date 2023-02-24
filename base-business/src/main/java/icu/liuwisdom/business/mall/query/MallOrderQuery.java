package icu.liuwisdom.business.mall.query;
import icu.liuwisdom.core.page.PageRequest;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@ApiModel(value = "MallOrderQuery对象" , description = "商城 订单信息")
public class MallOrderQuery extends PageRequest implements Serializable {

    @ApiModelProperty("用户id")
    private String fkUserId;

    @ApiModelProperty("订单状态 0=待支付 1=已取消 2=已支付 3=已收货 4=已退款")
    private Integer status;

    @ApiModelProperty("订单类型 0=积分订单 1=余额订单")
    private Integer type;

    @ApiModelProperty("支付方式 0=系统内部 1=微信 2=支付宝 3=信用卡 4=其他")
    private Integer payType;

    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("收货人手机号")
    private String phone;

    @ApiModelProperty("收货地址")
    private String address;

    @ApiModelProperty("总金额")
    private BigDecimal total;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
