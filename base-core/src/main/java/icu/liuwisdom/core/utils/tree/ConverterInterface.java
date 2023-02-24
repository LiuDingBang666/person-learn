package icu.liuwisdom.core.utils.tree;

/**
 * 转换接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 20:13
 */

public interface ConverterInterface<T extends AbstractBaseTreeVo<T>> {
    /**
     * PO转Vo
     *
     * @return V
     * @author LDB
     * @date 2023-01-19
     **/
    AbstractBaseTreeVo<T> toVo();

    /**
     * 获取实际的Vo数据
     *
     * @return T
     * @author LDB
     * @date 2023-01-20
     **/
    T vo();
}
