package complex;

/**
 * 统计鸭子工厂实现类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 19:41
 */

public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new DuckCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new DuckCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new DuckCounter(new RubberDuck());
    }
}
