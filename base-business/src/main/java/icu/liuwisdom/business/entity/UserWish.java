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
 * 用户愿望表
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserWish对象", description = "用户愿望表")
public class UserWish extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "愿望名称", required = true)
    @NotEmpty(message = "愿望名称不能为空")
    private String name;

    @ApiModelProperty(value = "愿望内容")
    private String content;

    @ApiModelProperty(value = "描述图片")
    private String images;

    @ApiModelProperty(value = "是否公开愿望 0=公开 1=私人 ", required = true)
    @NotNull(message = "是否公开愿望不能为空")
    private Integer isPublish;

    @ApiModelProperty(value = "该愿望是否被选中 0=选中 1=未选中 ")
    private Integer isSelected;

    @ApiModelProperty(value = "该愿望是否被实现 0=实现 1=未实现 ")
    private Integer isImpl;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;


}
