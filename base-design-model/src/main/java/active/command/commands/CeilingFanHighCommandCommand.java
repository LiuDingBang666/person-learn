package active.command.commands;

import active.command.Command;
import active.command.components.CeilingFan;

/**
 * 吊扇命令实现类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:16
 */

public class CeilingFanHighCommandCommand implements Command {
    CeilingFan ceilingFan;
    Integer prevSpeed;

    public CeilingFanHighCommandCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.on();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            // 切换到高度,todo 其他依次类推
        }
    }
}
