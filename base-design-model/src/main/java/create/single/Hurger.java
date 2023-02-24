package create.single;

/**
 * 单例-饿汉
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-22 16:59
 */

public class Hurger {
    private volatile static Hurger instance;

    private Hurger() {
    }

    public static Hurger getInstance() {
        // todo 为空才进行同步验证
        if (instance == null) {
            synchronized (Hurger.class) {
                if (instance == null) {
                    instance = new Hurger();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Hurger.getInstance());
        System.out.println(Hurger.getInstance());
    }
}
