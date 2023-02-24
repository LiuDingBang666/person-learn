package active.command.components;

import active.command.Device;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 吊扇
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:14
 */
@Data
@NoArgsConstructor
public class CeilingFan extends Device {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    @Override
    public void on() {
        super.on();
        System.out.println("Light On");
    }

    @Override
    public void off() {
        super.off();
        System.out.println("Light off");
    }
}
