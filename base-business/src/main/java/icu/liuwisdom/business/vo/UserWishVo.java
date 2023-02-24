package icu.liuwisdom.business.vo;

import icu.liuwisdom.business.entity.UserWish;
import icu.liuwisdom.business.entity.UserWishImpl;
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
@ApiModel(value = "用户愿望Vo对象", description = "用户愿望表")
public class UserWishVo extends UserWish {

    @ApiModelProperty(value = "愿望实现类")
    private UserWishImpl wishImpl;
}
