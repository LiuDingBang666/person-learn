package icu.liuwisdom.business.vo;

import icu.liuwisdom.business.entity.LogRecordMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 日志留言回复表Vo
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "日志留言回复表Vo对象", description = "日志留言回复表")
public class LogRecordMessageVo extends LogRecordMessage {


    @ApiModelProperty(value = "日志记录id", required = true)
    @NotEmpty(message = "日志记录id不能为空")
    private String fkLogRecord;

    @ApiModelProperty(value = "上级留言")
    private String parentId;

    @ApiModelProperty(value = "上级留言用户名")
    private String parentUserName;

    @ApiModelProperty(value = "留言内容", required = true)
    @NotEmpty(message = "留言内容不能为空")
    private String content;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String userImage;


    @ApiModelProperty(value = "子留言")
    private List<LogRecordMessageVo> children = new ArrayList<>();
}
