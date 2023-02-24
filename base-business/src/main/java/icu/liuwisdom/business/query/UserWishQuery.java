package icu.liuwisdom.business.query;

import icu.liuwisdom.core.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value = "用户愿望Query对象", description = "用户愿望表")
public class UserWishQuery extends PageRequest {

    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "愿望名称")
    private String name;

    @ApiModelProperty(value = "愿望内容")
    private String content;

    @ApiModelProperty(value = "该愿望是否被选中 0=选中 1=未选中 ")
    private Integer isSelected;

    @ApiModelProperty(value = "该愿望是否被实现 0=实现 1=未实现 ")
    private Integer isImpl;

    @ApiModelProperty(value = "是否公开愿望 0=公开 1=私人 ", required = true)
    private Integer isPublish;

}
