package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.data.Textures;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.TestSprite;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The in-game GameState.
 */

public class InGameState extends GameState {

    private TestSprite testSprite1;
    private TestSprite testSprite2;

    public InGameState(){
        try {
            Textures.loadTexture("test1.png");
            Textures.loadTexture("test2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        testSprite1 = new TestSprite(-.2f, -.2f, "test1");
        testSprite2 = new TestSprite(.2f, .2f, "test2");
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Renderer.beginRender();
        testSprite1.render();
        testSprite2.render();
        Renderer.endRender();
    }

}
