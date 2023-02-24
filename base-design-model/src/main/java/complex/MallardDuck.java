package complex;

import complex.Observer;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 18:20
 */

public class MallardDuck implements Quackable {
    @Override
    public String toString() {
        return "MallardDuck";
    }

    /**
     * 委托类
     *
     * @author LDB
     * @date 2023-01-24 21:00
     * @version 1.0
     */

    Observable observable;

    public MallardDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
