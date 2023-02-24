package construct.decorate.test;

import construct.decorate.Beverage;
import construct.decorate.components.Espresso;
import construct.decorate.components.HouseBlend;
import construct.decorate.decorates.Mocha;
import construct.decorate.decorates.Whip;

/**
 * 装饰者测试类
 * todo 可能会增加代码编写的复杂度，但是会有工厂或生成去模式来帮我们生成装饰对象来帮我们简单化
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 7:40
 */

public class Test {
    public static void main(String[] args) {
        // 点一杯浓缩咖啡，啥也不加
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());
        // 点一杯星巴克 加点牛奶和大豆
        Beverage beverage2 = new HouseBlend();
        // 加两份摩卡
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        // 加甜点
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + "$" + beverage2.cost());
    }
}
