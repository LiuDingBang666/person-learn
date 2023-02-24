package construct.decorate;

import lombok.Data;

/**
 * 抽象饮料类 Component
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-21 6:42
 */
@Data
public abstract class Beverage {
    /**
     * 描述
     *
     * @author LDB
     * @date 2023-01-21 6:43
     * @version 1.0
     */
    protected String description = "default desc";


    /**
     * 计算成本的方法
     *
     * @return java.lang.Double
     * @author LDB
     * @date 2023-01-21
     **/
    public abstract Double cost();
}
