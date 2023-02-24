package complex;

/**
 * 观察者接口 - 订阅者
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 21:03
 */

public interface Observer {
    /**
     * 观察丫丫
     *
     * @param duck
     * @author LDB
     * @date 2023-01-24
     **/
    void update(QuackObservable duck);
}
