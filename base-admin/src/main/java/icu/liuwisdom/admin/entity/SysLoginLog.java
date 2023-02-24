package icu.liuwisdom.admin.entity;

import java.io.Serializable;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统登录日志
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统登录日志")
public class SysLoginLog extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 登录状态
     */
    @ApiModelProperty("登录状态")
    private String status;

    /**
     * IP地址
     */
    @ApiModelProperty("IP地址")
    private String ip;

}
