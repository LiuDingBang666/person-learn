package complex;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 18:20
 */

public class RubberDuck implements Quackable {
    @Override
    public String toString() {
        return "RubberDuck";
    }

    /**
     * 委托类
     *
     * @author LDB
     * @date 2023-01-24 21:00
     * @version 1.0
     */

    Observable observable;

    public RubberDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        notifyObservers();
        System.out.println("Squeak");
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
