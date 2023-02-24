package create.facotry.simple;

/**
 * 披萨商店
 * todo 工厂方法顶级类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 8:58
 */

public class PizzaStore {

    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    /**
     * 选择披萨
     * todo 该类不能被覆盖
     *
     * @param type 类型
     * @return create.facotry.simple.Pizza
     * @author LDB
     * @date 2023-01-21
     **/
    public final Pizza orderPizza(String type) {
        Pizza pizza = null;
        pizza = factory.createPizza(type);
        // todo 制作披萨的固定流程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
};
