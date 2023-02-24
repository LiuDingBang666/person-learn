package icu.liuwisdom.admin.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统用户")
public class SysUser extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 加密盐
     */
    @ApiModelProperty("加密盐")
    private String salt;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty("状态  0：禁用   1：正常")
    private Integer status;

    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    private String deptId;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty("用户类型 0=普通用户 1=管理员")
    private Integer userType;


    private SysUserVo toVo() {
        SysUserVo vo = new SysUserVo();
        vo.setId(this.getId());
        vo.setName(this.name);
        vo.setNickName(this.nickName);
        vo.setAvatar(this.avatar);
        vo.setPassword(this.password);
        vo.setSalt(this.salt);
        vo.setEmail(this.email);
        vo.setMobile(this.mobile);
        vo.setStatus(this.status);
        vo.setDeptId(this.deptId);
        vo.setCreateBy(this.getCreateBy());
        vo.setCreateTime(this.getCreateTime());
        vo.setLastUpdateBy(this.getLastUpdateBy());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        vo.setDelFlag(this.delFlag);
        vo.setUserType(this.userType);
        return vo;
    }

}
