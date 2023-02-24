package active.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态数据
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {
    /**
     * 温度
     *
     * @author LDB
     * @date 2023-01-20 18:02
     * @version 1.0
     */

    private String warm;

    /**
     * 湿度
     *
     * @author LDB
     * @date 2023-01-20 18:02
     * @version 1.0
     */
    private String humidity;

    /**
     * 气压
     *
     * @author LDB
     * @date 2023-01-20 18:02
     * @version 1.0
     */
    private String airPressure;

}
