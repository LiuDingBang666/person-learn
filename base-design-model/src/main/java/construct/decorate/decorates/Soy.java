package construct.decorate.decorates;

import construct.decorate.CondimentDecorator;
import construct.decorate.Beverage;

/**
 * 具体装饰对象
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 7:44
 */

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        // 传入需要装饰的对象
        this.beverage = beverage;
    }

    /**
     * 装饰者不仅仅只是描述饮料，完整将调料出来描述
     *
     * @author LDB
     * @date 2023-01-21 8:01
     * @version 1.0
     */

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",大豆";
    }

    @Override
    public Double cost() {
        return beverage.cost() + 2;
    }
}
