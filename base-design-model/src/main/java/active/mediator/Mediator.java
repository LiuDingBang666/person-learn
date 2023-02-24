package active.mediator;

import lombok.Data;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:52
 */
@Data
public class Mediator implements Event {
    Alarm alarm = new Alarm();
    Sprinkler event = new Sprinkler();

    @Override
    public void onEvent() {
        if (alarm.state == 0) {
            alarm.onEvent();
            event.onEvent();
        } else {
            alarm.onEvent();
        }
    }
}
