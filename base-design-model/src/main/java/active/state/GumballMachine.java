package active.state;

import lombok.Data;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-23 22:22
 */
@Data
public class GumballMachine implements State {

    String location;
    /**
     * 卖空状态
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */

    State soldOutState;
    /**
     * 没钱状态
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */

    State noQuarterState;
    /**
     * 有钱状态
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */

    State hasQuarterState;
    /**
     * 出售状态
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */

    State soldState;
    /**
     * 现在持有的状态
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */
    State state = soldOutState;
    /**
     * 糖果数量
     *
     * @author LDB
     * @date 2023-01-24 14:41
     * @version 1.0
     */

    int count = 0;

    public GumballMachine(String location, int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.location = location;
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void dispense() {
        state.dispense();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
}
