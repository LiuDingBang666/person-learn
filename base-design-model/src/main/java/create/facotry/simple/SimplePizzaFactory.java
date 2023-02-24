package create.facotry.simple;

/**
 * 简单工厂
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 8:54
 */

public class SimplePizzaFactory {


    public Pizza createPizza(String type) {
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
