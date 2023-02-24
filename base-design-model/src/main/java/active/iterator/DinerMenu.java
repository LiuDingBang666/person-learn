package active.iterator;

/**
 * 菜单信息
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 21:20
 */
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    /**
     * 创建一个迭代器
     *
     * @author LDB
     * @date 2023-01-23 21:24
     * @version 1.0
     */

    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
