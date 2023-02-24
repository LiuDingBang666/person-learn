package complex;

import complex.Observer;

/**
 * 鹅适配器
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 19:12
 */

public class GooseAdapter implements Quackable {
    Goose goose;

    @Override
    public String toString() {
        return "GooseAdapter";
    }

    /**
     * 委托类
     *
     * @author LDB
     * @date 2023-01-24 21:00
     * @version 1.0
     */

    Observable observable;

    public GooseAdapter() {
        observable = new Observable(this);
    }

    public GooseAdapter(Goose goose) {
        observable = new Observable(this);
        this.goose = goose;
    }

    /**
     * 让鹅也可以像鸭子一样叫
     *
     * @author LDB
     * @date 2023-01-24
     **/
    @Override
    public void quack() {
        notifyObservers();
        goose.honk();
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
