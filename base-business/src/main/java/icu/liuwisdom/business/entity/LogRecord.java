package icu.liuwisdom.business.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@ApiModel(value = "LogRecord对象", description = "日志记录表")
public class LogRecord extends BaseModel {


    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "标题", required = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "内容", required = true)
    @NotEmpty(message = "内容不能为空")
    private String content;

    @ApiModelProperty(value = "是否公开 1=是 0=否", required = true)
    @NotNull(message = "是否公开不能为空")
    private Integer isPublic;

    @ApiModelProperty(value = "图片")
    private String images;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;


}
