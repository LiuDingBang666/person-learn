package active.command.components;

import active.command.Device;
import lombok.Data;

/**
 * 车库门
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 19:14
 */
@Data
public class GarageDoor extends Device implements active.command.GarageDoor {
    @Override
    public void up() {
        System.out.println("GarageDoor up");
    }

    @Override
    public void down() {
        System.out.println("GarageDoor down");
    }

    @Override
    public void stop() {
        System.out.println("GarageDoor stop");
    }

    @Override
    public void lightOn() {
        System.out.println("GarageDoor lightOn");
    }

    @Override
    public void lightOff() {
        System.out.println("GarageDoor lightOff");
    }
}
