package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("登录日志-查询")
@Data
public class SysLoginLogQuery extends PageRequest implements Serializable {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("登录状态")
    private String status;
    @ApiModelProperty("ip;")
    private String ip;

}