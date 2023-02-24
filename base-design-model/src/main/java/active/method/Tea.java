package active.method;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 11:11
 */

public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println(" brew Tea");
    }

    @Override
    void addCondiments() {
        System.out.println("addCondiments Tea");
    }


}
