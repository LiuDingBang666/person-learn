package construct.facade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动外观类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 10:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveFacade implements Active {
    A a;
    B b;
    C c;

    /**
     * 同一动作外观，简化接口
     *
     * @author LDB
     * @date 2023-01-23
     **/
    @Override
    public void action() {
        a.playGame();
        b.music();
        c.playBasketball();
    }
}
