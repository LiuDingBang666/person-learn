package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("消息-查询")
@Data
public class SysMessageQuery extends PageRequest implements Serializable {

    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty(message = "用户id不能为空")
    private String fkUserId;

    @ApiModelProperty(value = "状态: 1=待查看 2=已查看 3=已处理", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "消息类型")
    private String type;

}