package active.observer;

/**
 * 抽象数据观察者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:03
 */

public interface WeatherDataPublisherInterface<M extends State, O extends Observer> {
    /**
     * 新增观察者
     *
     * @param o
     * @author LDB
     * @date 2023-01-20
     **/
    void addObserver(O o);

    /**
     * 移除观察者
     *
     * @param
     * @author LDB
     * @date 2023-01-20
     **/
    void removeObserver(String id);

    /**
     * 接收消息并通知所有观察者
     *
     * @author LDB
     * @date 2023-01-20 18:15
     * @version 1.0
     */
    void notifyAll(M m);

    /**
     * 更新消息
     *
     * @param m
     * @author LDB
     * @date 2023-01-20
     **/
    void update(M m);
}
