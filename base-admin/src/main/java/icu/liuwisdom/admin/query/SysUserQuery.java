package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("用户信息-查询")
@Data
public class SysUserQuery extends PageRequest implements Serializable {

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


    @ApiModelProperty("用户类型 0=普通用户 1=管理员")
    private Integer userType;


}