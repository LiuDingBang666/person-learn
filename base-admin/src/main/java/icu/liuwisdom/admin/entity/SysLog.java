package icu.liuwisdom.admin.entity;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 系统操作日志
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统日志")
public class SysLog extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty("ApiModelProperty")
    private String userName;

    /**
     * 用户操作
     */
    @ApiModelProperty("用户操作")
    private String operation;

    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String params;

    /**
     * 执行时长(毫秒)
     */
    @ApiModelProperty("执行时长(毫秒)")
    private Long time;

    /**
     * IP地址
     */
    @ApiModelProperty("IP地址")
    private String ip;

    /**
     * 执行结果 1=执行成功 2=执行失败
     */
    @ApiModelProperty("执行结果 1=执行成功 2=执行失败")
    private Long result;

    /**
     * 请求结果
     */
    @ApiModelProperty("请求结果")
    private String resultInfo;

    /**
     * 异常信息
     */
    @ApiModelProperty("异常信息")
    private String errorInfo;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String memo;


}
