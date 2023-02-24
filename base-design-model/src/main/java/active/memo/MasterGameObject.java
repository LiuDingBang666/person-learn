package active.memo;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:56
 */

public class MasterGameObject implements GameMemento {
    Game gameState;

    Game pre;

    Game getCurrentState() {
        return gameState;
    }

    void restoreState(Game gameState) {
        this.gameState = pre;
    }

    @Override
    public void saveGameState(Game game) {
        pre = gameState;
        this.gameState = game;
    }
}
