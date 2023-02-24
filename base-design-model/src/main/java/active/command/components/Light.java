package active.command.components;

import active.command.Device;
import lombok.Data;

/**
 * 灯类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:14
 */
@Data
public class Light extends Device {
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
