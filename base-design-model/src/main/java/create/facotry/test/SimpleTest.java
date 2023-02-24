package create.facotry.test;

import create.facotry.simple.PizzaStore;
import create.facotry.simple.SimplePizzaFactory;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 9:03
 */

public class SimpleTest {
    public static void main(String[] args) {
        System.out.println(new PizzaStore(new SimplePizzaFactory()).orderPizza("A").getDesc());
        System.out.println(new PizzaStore(new SimplePizzaFactory()).orderPizza("B").getDesc());

    }
}
