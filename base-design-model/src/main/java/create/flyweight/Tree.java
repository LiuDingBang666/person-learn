package create.flyweight;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:32
 */

public class Tree {
    String x;
    String y;
    Integer age;

    void display(String x,
                 String y,
                 Integer age) {
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("age:" + age);
    }
}
