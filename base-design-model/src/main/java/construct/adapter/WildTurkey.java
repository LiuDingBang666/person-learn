package construct.adapter;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 9:52
 */

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
