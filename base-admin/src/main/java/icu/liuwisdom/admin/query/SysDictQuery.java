package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("数据字典-查询")
@Data
public class SysDictQuery extends PageRequest implements Serializable {
    @ApiModelProperty("标签名")
    private String label;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("描述")
    private String description;

}