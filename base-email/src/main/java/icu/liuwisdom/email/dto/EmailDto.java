package icu.liuwisdom.email.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author LDB
 * @version 1.0
 * @date 2022-12-21 14:43
 */
@ApiModel("简单邮箱DTO")
@Data
public class EmailDto {
    @ApiModelProperty(value = "发送人", required = true)
    @NotEmpty(message = "发送人不能为空")
    private String from;

    @ApiModelProperty(value = "接收人", required = true)
    @NotEmpty(message = "接收人不能为空")
    private String to;

    @ApiModelProperty("抄送人")
    private String cc;

    @ApiModelProperty(value = "主题", required = true)
    private String subject;

    @ApiModelProperty(value = "内容", required = true)
    private String content;

    @ApiModelProperty("发送日期")
    private Date sentDate;

    @ApiModelProperty(value = "文件", hidden = true)
    private List<File> file;

    @ApiModelProperty("文件路径")
    private List<String> filePath;
}
