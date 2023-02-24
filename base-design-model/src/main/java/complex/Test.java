package complex;

/**
 * 复合模式测试
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 18:24
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        AbstractDuckFactory factory = new CountingDuckFactory();
        t.simulate(factory);
    }

    void simulate(AbstractDuckFactory factory) {
        // 工厂-装饰
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        // 适配
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        System.out.println("\nDuck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        System.out.println("The ducks quacked " + DuckCounter.getQuacks() + " times");
        // 组合-迭代
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseAdapter);
        // 创建观察者
        Quackllogist quackllogist = new Quackllogist();
        flockOfDucks.registerObserver(quackllogist);
        simulate(flockOfDucks);
        System.out.println("The ducks quacked " + DuckCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
