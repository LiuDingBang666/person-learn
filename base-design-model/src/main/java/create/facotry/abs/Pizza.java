package create.facotry.abs;

import lombok.Data;

import java.util.ArrayList;

/**
 * 顶级披萨类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 8:43
 */
@Data
public abstract class Pizza {


    PizzaStore store;

    public Pizza(PizzaStore store) {
        this.store = store;
    }

    /**
     * 当披萨需要原料时，直接问工厂要
     *
     * @author LDB
     * @date 2023-01-22 15:37
     * @version 1.0
     */

    public Pizza() {

    }

    protected String desc;

    String name;

    String dough;

    String sauce;

    ArrayList toppings = new ArrayList();

    public void prepare() {
        System.out.println("prepare " + name);
    }


    public void bake() {
        System.out.println("bake");
    }


    public void cut() {
        System.out.println("cut");
    }


    public void box() {
        System.out.println("box");
    }


}
