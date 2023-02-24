package icu.liuwisdom.core.utils.tree.test;

import com.alibaba.fastjson.JSON;
import icu.liuwisdom.core.utils.tree.AbstractBaseTreePo;
import icu.liuwisdom.core.utils.tree.AbstractBaseTreeVo;
import icu.liuwisdom.core.utils.tree.ConverterInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * 测试菜单树
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 20:30
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuPo extends AbstractBaseTreePo<MenuVo> implements ConverterInterface<MenuVo> {

    private String name;

    /**
     * 获取实际的对象
     * todo 必须通过Vo获取数据
     *
     * @return icu.liuwisdom.core.utils.tree.test.MenuVo
     * @author LDB
     * @date 2023-01-20
     **/
    @Override
    public MenuVo vo() {
        AbstractBaseTreeVo<MenuVo> vo = toVo();
        MenuVo menuVo = new MenuVo();
        // 原始数据赋值
        BeanUtils.copyProperties(vo, menuVo);
        menuVo.setName(this.getName());
        return menuVo;
    }
}
