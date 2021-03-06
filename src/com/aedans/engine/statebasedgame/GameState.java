package com.aedans.engine.statebasedgame;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class to be used in a StateBasedGame
 */

public abstract class GameState {

    /**
     * The Update function for the GameState.
     *
     * @param l: The time the update function was last called.
     */
    public abstract void update(long l);

    /**
     * The Render function for the GameState.
     */
    public abstract void render();

}
