package create.facotry.abs;

/**
 * 披萨商店
 * todo 可以通过该工厂制作不同的产品
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 8:58
 */

public abstract class PizzaStore {
    /**
     * 将创建披萨的活动延迟到子类中去实现
     *
     * @param type
     * @return create.facotry.simple.Pizza
     * @author LDB
     * @date 2023-01-21
     **/
    protected abstract Pizza createPizza(String type);

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
        // 实际上该类并不知道是谁来创建，怎样具体的执行，这就是解耦
        pizza = createPizza(type);
        // todo 制作披萨的固定流程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
};
