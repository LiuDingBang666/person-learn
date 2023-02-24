package active.mediator;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:50
 */

public class Alarm implements Event {
    Integer state;

    @Override
    public void onEvent() {
        b();
        System.out.println("check");
    }

    void b() {
        System.out.println("b");
    }
}
