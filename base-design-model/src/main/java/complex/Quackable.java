package complex;

/**
 * 鸭子接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 18:19
 */

public interface Quackable extends QuackObservable {
    /**
     * 叫
     *
     * @author LDB
     * @date 2023-01-24
     **/
    void quack();
}
