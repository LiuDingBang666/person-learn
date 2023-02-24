package icu.liuwisdom.business.mall.po;
import icu.liuwisdom.core.modal.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 订单进展信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@TableName("mall_order_process")
@ApiModel(value = "MallOrderProcess对象", description = "商城 订单进展信息")
public class MallOrderProcess extends BaseModel implements Serializable {

    @ApiModelProperty("订单id")
    private String fkOrderId;

    @ApiModelProperty("订单状态 0=待支付 1=已取消 2=已支付 3=已收货 4=已退款")
    private Integer status;

    @ApiModelProperty("进展名称")
    private String name;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;


}
