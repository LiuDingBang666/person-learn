package icu.liuwisdom.admin.entity;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 搜索记录表
 * </p>
 *
 * @author ldb
 * @since 2022-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SearchRecord对象", description = "搜索记录表")
public class SearchRecord extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "搜索内容")
    private String content;

}
