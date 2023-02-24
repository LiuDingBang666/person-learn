package active.state;

/**
 * sdfdsf@author LDB
 *
 * @version 1.0
 * @date 2023-01-24 14:32
 */

public interface State {
    /**
     * 放钱
     *
     * @author LDB
     * @date 2023-01-24 14:49
     * @version 1.0
     */

    void insertQuarter();

    /**
     * 退钱
     *
     * @author LDB
     * @date 2023-01-24
     **/
    void ejectQuarter();

    /**
     * 分配
     *
     * @author LDB
     * @date 2023-01-24
     **/
    void dispense();

    /**
     * 转动糖果机
     *
     * @author LDB
     * @date 2023-01-24
     **/
    void turnCrank();

}
