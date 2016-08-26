package com.aedans.engine.statebasedgame;

import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Loader;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.Viewport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for creating StateBasedGames.
 */

public abstract class StateBasedGame implements Runnable {

    /**
     * The List of GameStates for the StateBasedGame to use.
     */
    private List<GameState> gameStates = new ArrayList<>();

    /**
     * The ID of the active GameState.
     */
    private int activeGameState = 0;

    /**
     * The default StateBasedGame constructor.
     *
     * @param initGameState: The GameState for the StateBasedGame to start on.
     * @param gameStates: The List of GameStates for the StateBasedGame to use.
     */
    protected StateBasedGame(GameState initGameState, GameState... gameStates){
        this.gameStates.add(initGameState);
        Collections.addAll(this.gameStates, gameStates);
    }

    /**
     * Runs the StateBasedGame.
     */
    public void run(){
        while (!DisplayManager.isCloseRequested()){
            try {
                DisplayManager.updateDisplay();
                getActiveGameState().update();
                Viewport.update();
                getActiveGameState().render();
            } catch (Exception e){
                e.printStackTrace(System.out);
                Loader.cleanUp();
                Renderer.cleanUp();
                break;
            }
        }
        Loader.cleanUp();
    }

    protected int addGameState(GameState gameState){
        this.gameStates.add(gameState);
        return gameStates.size()-1;
    }

    protected GameState getActiveGameState() throws IndexOutOfBoundsException {
        return gameStates.get(activeGameState);
    }

    protected GameState getGameState(int gameStateID) throws IndexOutOfBoundsException {
        return gameStates.get(gameStateID);
    }

}
