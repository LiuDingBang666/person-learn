package active.observer;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.UUID;

/**
 * 观察者类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:29
 */
@Data
public class Observer<M> implements WeatherDataObserverInterface<M> {
    /**
     * 主键id
     *
     * @author LDB
     * @date 2023-01-20 18:12
     * @version 1.0
     */
    private String id = UUID.randomUUID().toString();

    /**
     * 实现具体的接收方法
     *
     * @param m
     * @author LDB
     * @date 2023-01-21
     **/
    @Override
    public void receive(M m) {
        System.out.println(id + " receive a message:" + JSON.toJSONString(m));
    }
}
