package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel("部门-查询")
@Data
public class SysDeptQuery extends PageRequest implements Serializable {
    @ApiModelProperty("机构名称")
    private String name;

    @ApiModelProperty("排序")
    private Integer orderNum;

}