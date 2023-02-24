package complex;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 观察委托类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 20:41
 */

public class Observable implements QuackObservable {
    ArrayList<Observer> observers = new ArrayList();
    QuackObservable duck;

    /**
     * 哪个鸭子在呱呱叫
     *
     * @param duck
     * @return null
     * @author LDB
     * @date 2023-01-24
     **/
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer next = iterator.next();
            next.update(duck);
        }
    }
}
