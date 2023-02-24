package icu.liuwisdom.admin.dto;

import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.entity.SysRoleMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统角色DTO")
public class SysRoleDto extends SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色菜单信息")
    private List<SysRoleMenu> sysRoleMenus;

}
