package active.observer;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象天气发布者类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:04
 */
public class Publisher<M extends State, O extends Observer> implements WeatherDataPublisherInterface<M, O> {
    /**
     * 当前消息状态
     *
     * @author LDB
     * @date 2023-01-20 18:18
     * @version 1.0
     */
    private M state;
    /**
     * 观察者名单
     *
     * @author LDB
     * @date 2023-01-20 18:17
     * @version 1.0
     */
    private Map<String, O> observers = new HashMap<>();

    @Override
    public void addObserver(O o) {
        observers.put(o.getId(), o);
    }

    @Override
    public void removeObserver(String id) {
        observers.remove(id);
    }

    @Override
    public void update(M m) {
        System.out.println("Publish a Message:" + JSON.toJSONString(m));
        this.state = m;
    }

    @Override
    public void notifyAll(M m) {
        update(m);
        observers.values().stream().peek(val ->
                val.receive(m)
        ).count();
    }
}
