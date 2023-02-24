package active.command;

import active.command.commands.GarageDoorOpenCommand;
import active.command.commands.LightOnCommand;
import active.command.components.GarageDoor;
import active.command.components.Light;
import active.command.controls.SimpleRemoteControl;

/**
 * 命令测试类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:21
 */

public class Test {
    public static void main(String[] args) {
        // 遥控器 -> 命令 -> 灯
        SimpleRemoteControl remoteControl = new SimpleRemoteControl(new LightOnCommand(new Light()));
        // 开灯
        remoteControl.buttonWasPressed();
        //  开舱门
        remoteControl.setSlot(new GarageDoorOpenCommand(new GarageDoor()));
        remoteControl.buttonWasPressed();
    }
}
