package icu.liuwisdom.core.utils.tree.test;

import icu.liuwisdom.core.utils.tree.AbstractBaseTreeVo;
import lombok.Data;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 20:30
 */
@Data
public class MenuVo extends AbstractBaseTreeVo<MenuVo> {

    private String name;
}
