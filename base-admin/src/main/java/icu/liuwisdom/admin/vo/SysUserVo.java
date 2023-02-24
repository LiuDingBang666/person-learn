package icu.liuwisdom.admin.vo;

import icu.liuwisdom.admin.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApiModel("用户信息VO")
@Data
public class SysUserVo extends SysUser implements Serializable {
    @ApiModelProperty("验证码")
    private String captcha;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String deptName;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleNames;
    /**
     * 用户角色
     */
    @ApiModelProperty("用户角色")
    private List<SysUserRole> userRoles = new ArrayList<>();

    @ApiModelProperty("部门信息")
    private SysDept dept;

    @ApiModelProperty("菜单信息")
    private List<SysMenu> sysMenu;

    @ApiModelProperty("菜单树")
    private List<SysMenuVo> sysMenuTree;

    @ApiModelProperty("用户权限")
    private Set<String> permission;
}