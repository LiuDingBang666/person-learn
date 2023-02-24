package icu.liuwisdom.business.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 日志记录表
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "日志记录Query对象", description = "日志记录表")
public class LogRecordQuery extends PageRequest {


    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "是否公开 1=是 0=否")
    private Integer isPublic;

}
