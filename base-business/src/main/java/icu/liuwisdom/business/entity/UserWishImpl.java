package icu.liuwisdom.business.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 愿望实现表
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserWishImpl对象", description = "愿望实现表")
public class UserWishImpl extends BaseModel {


    @ApiModelProperty(value = "实现用户id", required = true)
    @NotEmpty(message = "实现人不能为空")
    private String fkUserId;

    @ApiModelProperty(value = "实现人")
    private String userName;

    @ApiModelProperty(value = "愿望id", required = true)
    @NotEmpty(message = "愿望id不能为空")
    private String fkWishId;

    @ApiModelProperty(value = "实现描述", required = true)
    @NotEmpty(message = "实现描述不能为空")
    private String desc;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
