package com.thrashplay.jounce.component.ai;

import com.thrashplay.jounce.Jounce;
import com.thrashplay.luna.api.engine.GameObject;
import com.thrashplay.luna.api.component.Position;
import com.thrashplay.luna.api.engine.GameObjectManager;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
public class DelayedBallChasingPaddleController extends MissingBallChasingController {

    private Jounce jounce;
    private GameObjectManager gameObjectManager;

    private long delayEndTime = -1;

    public DelayedBallChasingPaddleController(Jounce jounce, GameObjectManager gameObjectManager) {
        super(jounce, gameObjectManager);
        this.jounce = jounce;
        this.gameObjectManager = gameObjectManager;
    }

    @Override
    protected int getNextDestination(GameObject gameObject) {
        Position position = gameObject.getComponent(Position.class);

        if (delayEndTime == -1) {
            delayEndTime = System.currentTimeMillis() + 50;
        } else if (delayEndTime < System.currentTimeMillis()) {
            delayEndTime = -1;
            return super.getNextDestination(gameObject);
        }

        // wait longer, stay where we are
        int paddleCenterY = (int) position.getY() + (position.getHeight() / 2);
        return paddleCenterY;
    }
}
