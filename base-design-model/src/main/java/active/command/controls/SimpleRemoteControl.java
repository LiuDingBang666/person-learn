package active.command.controls;

import active.command.Command;
import lombok.Data;

/**
 * 简单遥控器
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:26
 */
@Data
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    /**
     * 改变行为可以多次调用
     *
     * @author LDB
     * @date 2023-01-22 19:28
     * @version 1.0
     */

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }

    /**
     * 按下指定按钮
     *
     * @author LDB
     * @date 2023-01-22
     **/
    public void buttonWasPressed() {
        slot.execute();
    }
}
