package com.thrashplay.jounce;

import com.thrashplay.jounce.entity.Player;
import com.thrashplay.luna.api.geom.Rectangle;
import com.thrashplay.luna.api.input.BackButtonManager;
import com.thrashplay.luna.api.input.MultiTouchManager;
import com.thrashplay.luna.api.input.TouchManager;
import com.thrashplay.luna.api.sound.SoundManager;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
public interface Jounce {
    Player getLastPlayerToScore();

    int getLeftPlayerScore();

    void addPointForLeftPlayer();

    int getRightPlayerScore();

    void addPointForRightPlayer();

    void clearScores();

    TouchManager getTouchManager();

    MultiTouchManager getMultiTouchManager();

    SoundManager getSoundManager();

    BackButtonManager getBackButtonManager();

    Rectangle getGameBoardDimensions();

    float getWidthScalar();

    float getHeightScalar();
}


