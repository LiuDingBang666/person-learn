package create.facotry.method;

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
