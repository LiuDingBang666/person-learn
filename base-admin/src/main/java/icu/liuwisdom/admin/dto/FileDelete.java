package icu.liuwisdom.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 文件删除dto
 *
 * @author ldb
 * @date 2022-07-16
 */
@Data
@ApiModel("文件删除表单")
public class FileDelete {
    @ApiModelProperty(value = "文件url", required = true)
    @NotEmpty(message = "文件url不能为空")
    private String url;
}
