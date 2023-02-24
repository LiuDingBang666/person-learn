package active.agency;

import active.state.GumballMachine;

/**
 * 糖果监视器
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-24 15:32
 */

public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        System.out.println("Gumall Machine: " + machine.getLocation());
        System.out.println("Current Inventory:" + machine.getCount() + " gumballs");
        System.out.println("Current State" + machine.getState());
    }
}
