package active.method;

/**
 * 模板方法测试
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 11:11
 */

public class Test {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }
}
