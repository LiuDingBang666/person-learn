package icu.liuwisdom.core.utils.tree;

import com.alibaba.fastjson.JSON;
import icu.liuwisdom.core.utils.tree.test.MenuPo;
import lombok.val;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 树工具
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 20:07
 */
public class TreeUtils {
    /**
     * 构建树数据
     *
     * @param lists 源数据
     * @return java.util.List<V>
     * @author LDB
     * @date 2023-01-19
     **/
    public static <P extends AbstractBaseTreePo, V extends AbstractBaseTreeVo> List<V> build(List<P> lists) {
        val vos = lists.stream().map(AbstractBaseTreePo::vo).collect(Collectors.toList());
        List<AbstractBaseTreeVo> firths = vos.stream()
                .filter(val -> StringUtils.isEmpty(val.getParentId()))
                .peek(val -> val.getIds().add(val.getId()))
                .collect(Collectors.toList());
        buildChildren(firths, vos);
        return (List<V>) firths;
    }

    public static <P extends AbstractBaseTreeVo, V extends AbstractBaseTreeVo> List<V> buildVo(List<P> lists) {
        List<AbstractBaseTreeVo> firths = lists.stream()
                .filter(val -> StringUtils.isEmpty(val.getParentId()))
                .peek(val -> val.getIds().add(val.getId()))
                .collect(Collectors.toList());
        buildChildren(firths, (List<AbstractBaseTreeVo>) lists);
        return (List<V>) firths;
    }

    /**
     * 构建子树
     *
     * @param firths 父节点
     * @param lists  源列表
     * @author LDB
     * @date 2023-01-20
     **/
    public static <D extends AbstractBaseTreeVo> void buildChildren(List<D> firths, List<D> lists) {
        firths.stream().peek(val -> {
            lists.stream().peek(meta -> {
                if (StringUtils.isNotEmpty(meta.getParentId()) && meta.getParentId().equals(val.getId())) {
                    // todo 赋值上一次的和现在的
                    val.getIds().stream().peek(id -> meta.getIds().add(id)).count();
                    meta.getIds().add(meta.getId());
                    val.getChildren().add(meta);
                }
            }).count();
            if (!val.getChildren().isEmpty()) {
                buildChildren(val.getChildren(), lists);
            }
        }).count();
    }

    public static void main(String[] args) {
        MenuPo l1 = new MenuPo("一级1");
        l1.setId("1");
        MenuPo l2 = new MenuPo("一级2");
        l2.setId("2");
        MenuPo l21 = new MenuPo("一级1-二级1");
        l21.setId("3");
        l21.setParentId("1");
        MenuPo l31 = new MenuPo("一级1-二级1-三级1");
        l31.setId("4");
        l31.setParentId("3");
        List list = new ArrayList<MenuPo>();
        Collections.addAll(list, l1, l2, l21, l31);
        List vos = TreeUtils.build(list);
        System.out.println(JSON.toJSONString(vos));
    }

}
