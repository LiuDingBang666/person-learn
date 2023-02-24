package icu.liuwisdom.core.utils.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 树Po字段
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 19:14
 */
@Getter
@Setter
public abstract class AbstractBaseTreePo<V extends AbstractBaseTreeVo<V>> extends BaseTreePo implements ConverterInterface<V> {
    @Override
    public AbstractBaseTreeVo<V> toVo() {
        AbstractBaseTreeVo<V> vo = new AbstractBaseTreeVo<V>() {
            @Override
            public List<V> getChildren() {
                return super.getChildren();
            }

            @Override
            public void setChildren(List<V> children) {
                super.setChildren(children);
            }
        };
        vo.setId(this.getId());
        vo.setParentId(this.getParentId());
        vo.setChildren(new ArrayList<>());
        vo.setCreateTime(this.getCreateTime());
        vo.setCreateBy(this.getCreateBy());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        vo.setFkUpdateUserId(this.getFkUpdateUserId());
        vo.setFkCreateUserId(this.getFkCreateUserId());
        return vo;
    }
}
