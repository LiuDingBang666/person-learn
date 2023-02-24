package active.observer;

import lombok.Data;

/**
 * 观察者类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-20 18:29
 */
@Data
public class StateObserver extends Observer<State> {
    @Override
    public void receive(State state) {
        System.out.println("状态告示板 当前状态:" + state.getAirPressure() + "," + state.getWarm() + "," + state.getAirPressure());
    }
}
