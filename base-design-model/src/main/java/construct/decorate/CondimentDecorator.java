package construct.decorate;

/**
 * 装饰者接口
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 7:41
 */

public abstract class CondimentDecorator extends Beverage {
    /**
     * 所有装饰者都必须实现该方法
     *
     * @author LDB
     * @date 2023-01-21 7:56
     * @version 1.0
     */
    public abstract String getDescription();
}
