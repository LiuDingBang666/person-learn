package active.observer.test;

import active.observer.Observer;
import active.observer.Publisher;
import active.observer.State;
import active.observer.StateObserver;

/**
 * 观察者模式测试类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:25
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Publisher<State, Observer> publisher = new Publisher<>();
        Observer<State> observer1 = new Observer<>();
        Observer<State> observer2 = new Observer<>();
        Observer<State> observer3 = new Observer<>();
        Observer<State> observer4 = new StateObserver();
        publisher.addObserver(observer1);
        publisher.addObserver(observer2);
        publisher.addObserver(observer3);
        publisher.addObserver(observer4);
        while (true) {
            Thread.sleep(2000);
            publisher.notifyAll(new State("温度20度", "湿度15度", "气压20度"));
            publisher.removeObserver(observer1.getId());
        }
    }
}
