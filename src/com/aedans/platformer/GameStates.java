package com.aedans.platformer;

import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.InGameState;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The enum containing all GameStates.
 */

public enum GameStates {

    /**
     * List of GameStates.
     */
    IN_GAME(0, new InGameState());

    /**
     * The ID of the GameState.
     */
    private int id;

    private GameState gameState;

    GameStates(int id, GameState gameState){
        this.id = id;
        this.gameState = gameState;
    }

    public int getId() {
        return id;
    }

    public GameState getGameState() {
        return gameState;
    }

}
