package active.state;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 14:39
 */

public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void turnCrank() {

    }
}
