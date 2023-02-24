package icu.liuwisdom.business.mall.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@TableName("mall_product_activity")
@ApiModel(value = "MallProductActivity对象", description = "商城 产品活动")
public class MallProductActivity extends BaseModel implements Serializable {

    @ApiModelProperty(value = "商品id", required = true)
    @NotEmpty(message = "商品id不能为空")
    private String fkProductId;

    @ApiModelProperty(value = "活动名称", required = true)
    @NotEmpty(message = "活动名称不能为空")
    private String name;

    @ApiModelProperty("活动封面")
    private String cover;

    @ApiModelProperty("活动描述")
    private String description;

    @ApiModelProperty(value = "状态 0=未开始 1=进行中 2=已结束", required = true)
    @NotNull(message = "活动状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "活动商品数量", required = true)
    @NotNull(message = "活动商品数量不能为空")
    private Integer nums;

    @ApiModelProperty("当前库存")
    private Integer inventory;

    @ApiModelProperty("原价格（元）")
    private BigDecimal price;

    @ApiModelProperty("折扣价格（元）")
    private BigDecimal discountPrice;

    @ApiModelProperty("折扣")
    private Integer discountUnit;

    @ApiModelProperty(value = "是否可用积分兑换 0=不可用 1=可用", required = true)
    @NotNull(message = "是否可用积分兑换不能为空")
    private Integer isCreditsExchange;

    @ApiModelProperty("活动开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty("活动结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
