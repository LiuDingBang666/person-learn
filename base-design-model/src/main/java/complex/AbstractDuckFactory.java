package complex;

/**
 * 生产鸭子的抽象工厂
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 19:39
 */

public abstract class AbstractDuckFactory {
    /**
     * 创建不同类型的鸭子
     *
     * @return complex.Quackable
     * @author LDB
     * @date 2023-01-24
     **/
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
