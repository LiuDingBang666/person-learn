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
 * 角色菜单
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("角色菜单")
public class SysRoleMenu extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID", required = true)
    @NotEmpty(message = "菜单id不能为空")
    private String menuId;

}
