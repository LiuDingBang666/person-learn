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
 * 商城 分类信息
 * </p>
 *
 * @author ldb
 * @since 2023-01-27
 */
@Getter
@Setter
@ApiModel(value = "MallProductTypeQuery对象", description = "商城 分类信息")
public class MallProductTypeQuery extends PageRequest implements Serializable {

    @ApiModelProperty("部门id")
    private String fkDeptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("上级分类id")
    private String parentId;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("状态 0=已上架 1=已下架 2=已售馨")
    private Integer status;

    @ApiModelProperty("是否可用积分兑换 0=不可用 1=可用")
    private Integer isCreditsExchange;

}
