package construct.adapter;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 9:51
 */

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
