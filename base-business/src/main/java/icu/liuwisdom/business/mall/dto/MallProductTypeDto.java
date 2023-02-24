package icu.liuwisdom.business.mall.dto;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
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
@ApiModel(value = "MallProductTypeDto对象", description = "商城 分类信息")
public class MallProductTypeDto extends BaseModel implements Serializable {

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

    @ApiModelProperty(value = "名称", required = true)
    @NotEmpty(message = "名称不能为空")
    private String name;

}
