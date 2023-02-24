package icu.liuwisdom.core.utils.tree;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 树Po字段
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 19:14
 */
@ApiModel("树Po字段")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseTreePo extends BaseModel {

    @ApiModelProperty("上级id")
    private String parentId;
}
