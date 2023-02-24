package complex;

/**
 * 鸭子的观察者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 21:08
 */

public class Quackllogist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackllogist: " + duck + " just quacked.");
    }
}
