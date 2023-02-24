package complex;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合模式
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 20:01
 */

public class Flock implements Quackable {
    @Override
    public String toString() {
        return "Flock";
    }

    /**
     * 鸭群
     *
     * @author LDB
     * @date 2023-01-24 21:14
     * @version 1.0
     */

    ArrayList<Quackable> quackables = new ArrayList();

    /**
     * 委托类
     *
     * @author LDB
     * @date 2023-01-24 21:00
     * @version 1.0
     */

    Observable observable;

    public Flock() {
        observable = new Observable(this);
        // 注册观察者
        registerObserver(new Quackllogist());
    }

    /**
     * 新增鸭子
     *
     * @param quackable
     * @author LDB
     * @date 2023-01-24
     **/
    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    /**
     * 鸭子一起叫
     *
     * @author LDB
     * @date 2023-01-24
     **/
    @Override
    public void quack() {
        // todo 当一群鸭子一起叫时，通知所有滴观察者
        notifyObservers();
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            Quackable next = iterator.next();
            next.quack();
        }
    }

    /**
     * 注册观察者
     *
     * @param observer
     * @author LDB
     * @date 2023-01-24
     **/
    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
