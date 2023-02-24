package icu.liuwisdom.business.mall.po;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 商城 产品信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@TableName("mall_product")
@ApiModel(value = "MallProduct对象", description = "商城 产品信息")
public class MallProduct extends BaseModel implements Serializable {

    @ApiModelProperty("部门id")
    private String fkDeptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty(value = "产品名称", required = true)
    @NotEmpty(message = "产品名称不能为空")
    private String name;

    @ApiModelProperty(value = "库存", required = true)
    @NotNull(message = "库存不能为空")
    private Integer inventory;

    @ApiModelProperty(value = "状态 0=已上架 1=已下架 2=已售馨", required = true)
    @NotNull(message = "商品状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "价格（元）", required = true)
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "是否可用积分兑换 0=不可用 1=可用", required = true)
    @NotNull(message = "是否可用积分兑换不能为空")
    private Integer isCreditsExchange;

    @ApiModelProperty("产品封面")
    private String cover;

    @ApiModelProperty(value = "产品分类id", required = true)
    @NotNull(message = "产品分类不能为空")
    private String fkTypeId;

    @ApiModelProperty("产品分类名称")
    private String typeName;

    @ApiModelProperty("产品描述")
    private String description;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;


}
