package active.iterator;

/**
 * 餐厅迭代器接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 21:17
 */

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return items.length > 0 ? items.length - 1 != position && items[++position] != null : false;
    }

    @Override
    public MenuItem next() {
        position = position + 1;
        return items[position];
    }
}
