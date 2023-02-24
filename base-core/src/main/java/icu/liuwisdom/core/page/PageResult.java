package icu.liuwisdom.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页结果
 *
 * @author ldb
 * @ClassName PageResult.java
 * @Data 2022-02-19 15:11
 */
@Data
@ApiModel("分页结果")
@Deprecated
public class PageResult {
    @ApiModelProperty("页码")
    private int pageNum;
    @ApiModelProperty("页数")
    private int pageSize;
    @ApiModelProperty("总数据条数")
    private long totalSize;
    @ApiModelProperty("总页数")
    private int totalPages;
    @ApiModelProperty("数据")
    private List<?> content;
}
