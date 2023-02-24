package icu.liuwisdom.business.mall.query;
import icu.liuwisdom.core.page.PageRequest;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商城 产品活动
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallProductActivityQuery对象" , description = "商城 产品活动")
public class MallProductActivityQuery extends PageRequest implements Serializable {

    @ApiModelProperty("商品id")
    private String fkProductId;

    @ApiModelProperty("活动名称")
    private String name;

    @ApiModelProperty("活动封面")
    private String cover;

    @ApiModelProperty("活动描述")
    private String description;

    @ApiModelProperty("状态 0=未开始 1=进行中 2=已结束")
    private Integer status;

    @ApiModelProperty("活动商品数量")
    private String nums;

    @ApiModelProperty("当前库存")
    private Integer inventory;

    @ApiModelProperty("原价格（元）")
    private BigDecimal price;

    @ApiModelProperty("折扣价格（元）")
    private BigDecimal discountPrice;

    @ApiModelProperty("折扣")
    private Integer discountUnit;

    @ApiModelProperty("是否可用积分兑换 0=不可用 1=可用")
    private Integer isCreditsExchange;

    @ApiModelProperty("活动开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("活动结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
