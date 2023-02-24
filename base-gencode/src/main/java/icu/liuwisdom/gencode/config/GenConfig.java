package icu.liuwisdom.gencode.config;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 代码生成配置类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-18 14:30
 */
@ApiModel("代码生成配置类")
@Data
public class GenConfig {
    @ApiModelProperty(value = "数据库地址", required = true)
    @NotEmpty(message = "数据库地址不能为空")
    private String url;

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "表列表，多个以逗号分割", required = true)
    @NotEmpty(message = "表名不能为空")
    private String tables;

    @ApiModelProperty(value = "作者", required = true)
    @NotEmpty(message = "父包模块名不能为空")
    private String author;

    @ApiModelProperty("文件输出路径")
    private String outputDir;

    @ApiModelProperty(value = "父包模块名", required = true)
    @NotEmpty(message = "父包模块名不能为空")
    private String parent;

    @ApiModelProperty(value = "板块名称", required = true)
    @NotEmpty(message = "板块名称不能为空")
    private String moduleName;
}
