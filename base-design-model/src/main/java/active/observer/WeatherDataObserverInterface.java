package active.observer;

/**
 * 抽象数据观察者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:03
 */

public interface WeatherDataObserverInterface<M> {
    /**
     * 接收消息的方法
     *
     * @param m
     * @author LDB
     * @date 2023-01-20
     **/
    void receive(M m);
}
