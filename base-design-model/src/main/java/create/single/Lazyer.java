package create.single;

/**
 * 单例-饿汉
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 16:59
 */

public class Lazyer {
    private static Lazyer instance = new Lazyer();

    private Lazyer() {
    }

    public static Lazyer getInstance() {
        return instance;

    }

    public static void main(String[] args) {
        System.out.println(Lazyer.getInstance());
        System.out.println(Lazyer.getInstance());
    }
}
