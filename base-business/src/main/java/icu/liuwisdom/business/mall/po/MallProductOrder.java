package icu.liuwisdom.business.mall.po;
import icu.liuwisdom.core.modal.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@TableName("mall_product_order")
@ApiModel(value = "MallProductOrder对象", description = "商城 订单商品关联信息")
public class MallProductOrder extends BaseModel implements Serializable {

    @ApiModelProperty("订单id")
    private String fkOrderId;

    @ApiModelProperty("商品id")
    private String fkProductId;

    @ApiModelProperty("购买数量")
    private Integer nums;

    @ApiModelProperty("单笔总金额")
    private BigDecimal total;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;


}
