package complex;

/**
 * 鸭子观察者接口 - 发布者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 20:13
 */

public interface QuackObservable {
    /**
     * 注册观察者
     *
     * @param observer
     * @author LDB
     * @date 2023-01-24
     **/
    void registerObserver(Observer observer);

    /**
     * 通知观察者
     *
     * @author LDB
     * @date 2023-01-24
     **/
    void notifyObservers();
}
