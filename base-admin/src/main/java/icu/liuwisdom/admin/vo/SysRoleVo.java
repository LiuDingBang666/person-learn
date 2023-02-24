package icu.liuwisdom.admin.vo;

import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.entity.SysRole;
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
@ApiModel("系统角色VO")
public class SysRoleVo extends SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色菜单树")
    private List<SysMenuVo> menuTree;

    @ApiModelProperty("菜单列表")
    private List<SysMenu> menu;
}
