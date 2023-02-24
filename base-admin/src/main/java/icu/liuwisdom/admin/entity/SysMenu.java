package icu.liuwisdom.admin.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.admin.vo.SysMenuVo;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统菜单")
public class SysMenu extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty("父菜单ID，一级菜单为0")
    private String parentId;

    /**
     * 菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)
     */
    @ApiModelProperty("菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)")
    private String url;

    /**
     * 授权(多个用逗号分隔，如：sys:user:add,sys:user:alter)
     */
    @ApiModelProperty("授权(多个用逗号分隔，如：sys:user:add,sys:user:alter)")
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @ApiModelProperty("类型   0：目录   1：菜单   2：按钮")
    private Integer type;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty("菜单显示端 0=全部 1=管理端 2=用户端")
    private Long endpoint;


    public SysMenuVo toVo() {
        SysMenuVo vo = new SysMenuVo();
        vo.setId(this.getId());
        vo.setName(this.name);
        vo.setParentId(this.parentId);
        vo.setUrl(this.url);
        vo.setPerms(this.perms);
        vo.setType(this.type);
        vo.setIcon(this.icon);
        vo.setOrderNum(this.orderNum);
        vo.setCreateBy(this.getCreateBy());
        vo.setCreateTime(this.getCreateTime());
        vo.setLastUpdateBy(this.getLastUpdateBy());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        vo.setDelFlag(this.delFlag);
        vo.setEndpoint(this.endpoint);
        return vo;
    }


}
