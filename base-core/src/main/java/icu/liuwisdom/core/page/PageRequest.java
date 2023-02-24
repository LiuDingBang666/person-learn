package icu.liuwisdom.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页请求对象
 *
 * @author ldb
 * @ClassName PageRequest.java
 * @Data 2022-02-19 15:10
 */
@Data
@ApiModel("分页请求对象")
public class PageRequest implements Serializable {

    @ApiModelProperty("页码")
    private int pageNum = 1;

    @ApiModelProperty("页数")
    private int pageSize = 10;

    @ApiModelProperty("关键字")
    private String keyword;

    @ApiModelProperty("多个状态值，根据多个条件查询时用到 比如:1,2,3")
    private String dataStates;

    @ApiModelProperty(value = "主表id,一对多分页使用", hidden = true)
    private List<String> ids;
}
