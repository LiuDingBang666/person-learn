package active.command;

import lombok.Data;

/**
 * 设备接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:15
 */
@Data
public abstract class Device {
    /**
     * 状态 0 = 开  1 = 关
     *
     * @author LDB
     * @date 2023-01-22 19:15
     * @version 1.0
     */
    private Integer state;

    /**
     * 打开
     *
     * @author LDB
     * @date 2023-01-22 19:17
     * @version 1.0
     */
    public void on() {
        System.out.println("device on...");
        this.state = 0;
    }


    /**
     * 关闭
     *
     * @author LDB
     * @date 2023-01-22
     **/
    public void off() {
        System.out.println("device off...");
        this.state = 1;
    }
}
