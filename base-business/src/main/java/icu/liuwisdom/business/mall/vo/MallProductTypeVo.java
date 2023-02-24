package icu.liuwisdom.business.mall.vo;

import icu.liuwisdom.business.mall.po.MallProduct;
import icu.liuwisdom.core.utils.tree.AbstractBaseTreeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
@ApiModel(value = "MallProductTypeVo对象", description = "商城 分类信息")
public class MallProductTypeVo extends AbstractBaseTreeVo<MallProductTypeVo> implements Serializable {
    @ApiModelProperty("部门id")
    private String fkDeptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "商品信息", required = true)
    List<MallProduct> products = new ArrayList<>();

    @ApiModelProperty(value = "下级类型商品信息", required = true)
    List<MallProductTypeVo> children = new ArrayList<>();
}
