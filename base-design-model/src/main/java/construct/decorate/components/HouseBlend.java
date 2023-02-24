package construct.decorate.components;

import construct.decorate.Beverage;

/**
 * 都可 具体组件
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 6:43
 */

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "HouseBlend";
    }

    @Override
    public Double cost() {
        return 89D;
    }
}
