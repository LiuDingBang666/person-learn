package active.command.commands;

import active.command.Command;
import active.command.components.Light;

/**
 * 灯命令实现类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:16
 */

public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
