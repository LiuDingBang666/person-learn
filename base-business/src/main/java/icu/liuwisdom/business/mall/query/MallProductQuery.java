package icu.liuwisdom.business.mall.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@ApiModel(value = "MallProductQuery对象", description = "商城 产品信息")
public class MallProductQuery extends PageRequest implements Serializable {

    @ApiModelProperty("部门id")
    private String fkDeptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("产品名称")
    private String name;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("状态 0=已上架 1=已下架 2=已售馨")
    private Integer status;

    @ApiModelProperty("价格（元）")
    private BigDecimal price;

    @ApiModelProperty("是否可用积分兑换 0=不可用 1=可用")
    private Integer isCreditsExchange;

    @ApiModelProperty("产品封面")
    private String cover;

    @ApiModelProperty("产品分类id")
    private String fkTypeId;

    @ApiModelProperty("分类名称")
    private String typeName;

    @ApiModelProperty("产品描述")
    private String description;

}
