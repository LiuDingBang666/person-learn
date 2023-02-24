package active.command.commands;

import active.command.Command;
import active.command.GarageDoor;

/**
 * 车库门命令实现类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:16
 */

public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
