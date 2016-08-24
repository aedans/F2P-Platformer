package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.data.Textures;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.TestSprite;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The in-game GameState.
 */

public class InGameState extends GameState {

    private Player player;

    public InGameState(){
        try {
            Textures.loadTexture("player.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        player = new Player();
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render() {
        Renderer.beginRender();
        player.render();
        Renderer.endRender();
    }

}
