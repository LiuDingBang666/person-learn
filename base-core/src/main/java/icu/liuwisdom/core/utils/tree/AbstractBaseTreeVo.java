package icu.liuwisdom.core.utils.tree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * 树Vo
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 20:05
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("抽象树数据")
public abstract class AbstractBaseTreeVo<V extends AbstractBaseTreeVo<V>> extends BaseTreePo {
    @ApiModelProperty("id链")
    private List<String> ids = new ArrayList<>();

    @ApiModelProperty("子节点数据")
    List<V> children = new ArrayList<>();
}
