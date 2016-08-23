package com.aedans.platformer;

import com.aedans.engine.statebasedgame.StateBasedGame;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The main Game class.
 */

public class Game extends StateBasedGame {

    /**
     * The default Game constructor.
     */
    public Game() {
        super(GameStates.IN_GAME.getGameState());
    }

}
