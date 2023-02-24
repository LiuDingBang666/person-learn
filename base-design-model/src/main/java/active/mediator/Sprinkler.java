package active.mediator;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:50
 */

public class Sprinkler implements Event {

    Integer state;

    @Override
    public void onEvent() {
        a();
        System.out.println("check");
    }

    void a() {
        System.out.println("a");
    }
}
