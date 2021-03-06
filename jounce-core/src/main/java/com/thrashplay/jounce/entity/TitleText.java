package com.thrashplay.jounce.entity;

import com.thrashplay.jounce.Jounce;
import com.thrashplay.luna.api.geom.Rectangle;
import com.thrashplay.luna.api.graphics.Graphics;
import com.thrashplay.luna.api.graphics.Renderable;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
public class TitleText implements Renderable {
    private Jounce jounce;

    public TitleText(Jounce jounce) {
        this.jounce = jounce;
    }

    @Override
    public void render(Graphics graphics) {
        Rectangle gameBoardBounds = jounce.getGameBoardDimensions();
        graphics.drawString("JOUNCE", gameBoardBounds.getCenterX(), 150, 0xffffffff, 108, Graphics.HorizontalAlignment.Center);
//        graphics.drawString("Touch the screen to play", gameBoardBounds.getCenterX(), 105, 0xffffffff, 24, Graphics.HorizontalAlignment.Center);
    }
}
