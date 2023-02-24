package active.method;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 11:09
 */

public abstract class CaffeineBeverage {
    /**
     * 准备抽象方法
     *
     * @author LDB
     * @date 2023-01-23 11:12
     * @version 1.0
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        addCondiments();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Bolining water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 扩展钩子
     *
     * @author LDB
     * @date 2023-01-23
     **/
    boolean customerWantsCondiments() {
        return true;
    }

}
