package icu.liuwisdom.admin.vo;

import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.entity.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("部门VO")
@Data
public class SysDeptVo extends SysDept implements Serializable {

    /**
     * 子部门
     */
    @ApiModelProperty("子部门")
    private List<SysDeptVo> children;
    /**
     * 父部门名称
     */
    @ApiModelProperty("父部门名称")
    private String parentName;
    /**
     * 部门等级
     */
    @ApiModelProperty("部门等级")
    private Integer level;

    @ApiModelProperty("角色信息")
    private List<SysRole> sysRole;
}