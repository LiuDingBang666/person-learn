package active.command;

/**
 * 车库门接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:32
 */

public interface GarageDoor {
    /**
     * 开
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void up();

    /**
     * 关
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void down();

    /**
     * 停止
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void stop();

    /**
     * 开灯
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void lightOn();

    /**
     * 关灯
     *
     * @author LDB
     * @date 2023-01-22
     **/
    void lightOff();
}
