package active.iterator;

/**
 * 顶级迭代器接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 21:14
 */

public interface Iterator<T> {
    /**
     * 是否有下一个
     *
     * @author LDB
     * @date 2023-01-23 21:15
     * @version 1.0
     */

    boolean hasNext();

    /**
     * 下一个
     *
     * @author LDB
     * @date 2023-01-23 21:15
     * @version 1.0
     */

    T next();
}
