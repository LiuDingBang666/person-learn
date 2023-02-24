package icu.liuwisdom.admin.entity;

import java.io.Serializable;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 角色机构
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统角色部门")
public class SysRoleDept extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", required = true)
    @NotEmpty(message = "角色id不能为空")
    private String roleId;

    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    private String deptId;


}
