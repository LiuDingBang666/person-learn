package icu.liuwisdom.admin.vo;

import icu.liuwisdom.admin.entity.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("系统菜单VO")
@Data
public class SysMenuVo extends SysMenu implements Serializable {

    /**
     * 父菜单名称-非数据库字段
     */
    @ApiModelProperty("父菜单名称")
    private String parentName;

    /**
     * 菜单等级
     */
    @ApiModelProperty("菜单等级")
    private Integer level;

    /**
     * 子菜单
     */
    @ApiModelProperty("子菜单")
    private List<SysMenuVo> children;

}