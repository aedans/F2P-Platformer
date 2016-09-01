package com.aedans.engine.renderer;

import org.lwjgl.opengl.GL11;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/6/2016.
 * <p>
 * The Viewport for the Game.
 */

public class Viewport {

    /**
     * The position of the Viewport.
     */
    public static float x = 0, y = 0;

    /**
     * The x and y velocity of the Viewport.
     */
    public static float xVel = 0, yVel = 0;

    /**
     * The time the Viewport was last translated.
     */
    private static long lastTranslated = System.currentTimeMillis();

    /**
     * Gets the position of a given position as seen through the Viewport.
     *
     * @param x: The position x.
     * @param y: The position y.
     * @return Point2D.Float: The on-screen position in the OpenGL Coordinate System.
     */
    public static Point2D.Float getRelativePosition(float x, float y) {
        return new Point2D.Float(x - Viewport.x, y - Viewport.y);
    }

    /**
     * Sets the position of the Viewport to a given position.
     *
     * @param x: The x position to set the Viewport to.
     * @param y: The y position to set the Viewport to.
     */
    public static void setPosition(float x, float y) {
        Viewport.x = x;
        Viewport.y = y;
    }

    /**
     * Function to be executed once every Game loop.
     */
    public static void update() {
        float m = (float) (lastTranslated - System.currentTimeMillis()) / 1000;
        x += xVel * m;
        y += yVel * m;
        lastTranslated = System.currentTimeMillis();
    }

}
