package create.facotry.test;

import create.facotry.method.APizzaStore;
import create.facotry.method.PizzaStore;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 9:03
 */

public class MethodTest {
    public static void main(String[] args) {
        //        System.out.println(new PizzaStore(new SimplePizzaFactory()).orderPizza("A").getDesc());
//        System.out.println(new PizzaStore(new SimplePizzaFactory()).orderPizza("B").getDesc());


        PizzaStore store = new APizzaStore();
        System.out.println(store.orderPizza("A").getDesc());

    }
}
