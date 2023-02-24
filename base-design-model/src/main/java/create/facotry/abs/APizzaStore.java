package create.facotry.abs;

/**
 * 让子类决定具体披萨该如何创建
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 9:44
 */

public class APizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("A".equals(type)) {
            pizza = new APizza();
        }
        if ("B".equals(type)) {
            pizza = new BPizza();
        }
        return pizza;
    }
}
