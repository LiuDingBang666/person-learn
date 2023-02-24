package construct.adapter;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 9:54
 */

public class Test {
    public static void main(String[] args) {
        TurkeyAdapter adapter = new TurkeyAdapter(new WildTurkey());
        adapter.quack();
        adapter.fly();
    }
}
