package construct.bridge;

/**
 * 抽象遥控器控制电视-改变抽象
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 9:39
 */

public abstract class RemoteControl {
    TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void on();

    abstract void aff();

    void nextChannel() {
        tv.tuneChannel();
    }
}
