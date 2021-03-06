package com.thrashplay.jounce.component.ai;

import com.thrashplay.jounce.Jounce;
import com.thrashplay.jounce.entity.GameObjectFactory;
import com.thrashplay.luna.api.engine.GameObject;
import com.thrashplay.luna.api.component.Position;
import com.thrashplay.luna.api.engine.GameObjectManager;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
public class PerfectBallChasingPaddleController extends MoveToDestinationPaddleController {

    private Jounce jounce;
    private GameObjectManager gameObjectManager;

    public PerfectBallChasingPaddleController(Jounce jounce, GameObjectManager gameObjectManager) {
        super(jounce);
        this.jounce = jounce;
        this.gameObjectManager = gameObjectManager;
    }

    @Override
    protected int getNextDestination(GameObject gameObject) {
        Position position = gameObject.getComponent(Position.class);
        Position ballPosition = getBallPosition();

        // ball position can be null if we are waiting for a ball to spawn
        if (ballPosition != null) {
            int ballCenterY = (int) ballPosition.getY() + (ballPosition.getHeight() / 2);
            return ballCenterY;
        } else {
            // no ball on gameboard currently, just stay where we are
            int paddleCenterY = (int) position.getY() + (position.getHeight() / 2);
            return paddleCenterY;
        }
    }

    public Position getBallPosition() {
        for (GameObject gameObject : gameObjectManager.getGameObjects()) {
            if (GameObjectFactory.ID_BALL.equals(gameObject.getId())) {
                return gameObject.getComponent(Position.class);
            }
        }

        // no ball was found
        return null;
    }
}
