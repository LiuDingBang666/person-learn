package active.chain;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:10
 */

public class Test {
    public static void main(String[] args) {
        AbstractHandler handler1 = new CeoAbstractHandler();
        AbstractHandler handler2 = new BadAbstractHandler();
        AbstractHandler handler3 = new NewMachineAbstractHandler();
        AbstractHandler handler4 = new RubbishAbstractHandler();
        handler1.next = handler2;
        handler2.next = handler3;
        handler3.next = handler4;
        Email email = new Email("粉丝邮箱", "Fans");
        handler1.handlerRequest(email);
    }
}
