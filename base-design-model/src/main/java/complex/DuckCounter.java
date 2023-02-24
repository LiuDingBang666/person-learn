package complex;

import complex.Observer;

/**
 * 鸭子装饰者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 19:22
 */

public class DuckCounter implements Quackable {
    Quackable quackable;
    static int numberOfQuacks;

    /**
     * 委托类
     *
     * @author LDB
     * @date 2023-01-24 21:00
     * @version 1.0
     */

    Observable observable;

    public DuckCounter() {
        observable = new Observable(this);
    }

    public DuckCounter(Quackable quackable) {
        observable = new Observable(this);
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        notifyObservers();
        quackable.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
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
