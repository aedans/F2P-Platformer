package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.TestSprite;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The in-game GameState.
 */

public class InGameState extends GameState {

    private TestSprite testSprite1 = new TestSprite(-.2f, -.2f);
    private TestSprite testSprite2 = new TestSprite(.2f, .2f);

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Renderer.prepare();
        testSprite1.render();
        testSprite2.render();
    }

}
