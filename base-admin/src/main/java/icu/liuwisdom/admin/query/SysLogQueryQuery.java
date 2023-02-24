package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("日志-查询")
@Data
public class SysLogQueryQuery extends PageRequest implements Serializable {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户操作")
    private String operation;
    @ApiModelProperty("请求方法")
    private String method;
    @ApiModelProperty("IP地址")
    private String ip;

}