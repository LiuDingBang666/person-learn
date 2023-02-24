package active.command.controls;

import active.command.Command;
import active.command.NoCommand;

/**
 * 遥控器
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 22:55
 */

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    Command undoCommand;


    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        // 初始化命令
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    /**
     * 设置命令
     *
     * @param slot       下标
     * @param onCommand  开命令
     * @param offCommand 关命令
     * @author LDB
     * @date 2023-01-22
     **/
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 开
     *
     * @param slot
     * @author LDB
     * @date 2023-01-22
     **/
    public void onButtonWasPushed(int slot) {
        undoCommand = onCommands[slot];
        onCommands[slot].execute();

    }

    /**
     * 关
     *
     * @param slot
     * @author LDB
     * @date 2023-01-22
     **/
    public void offButtonWasPushed(int slot) {
        undoCommand = offCommands[slot];
        offCommands[slot].execute();
    }

    /**
     * 撤销命令
     *
     * @author LDB
     * @date 2023-01-22
     **/
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n----Remote Control ----------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot ] " + i + "] " + onCommands[i].getClass().getName() + "  " + offCommands[i].getClass().getName() + "]\n");
        }
        return stringBuffer.toString();
    }
}
