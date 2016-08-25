package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;
import com.aedans.platformer.gamestates.ingame.sprites.TestSprite;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The in-game GameState.
 */

public class InGameState extends GameState {

    private EntityBox spriteBox;
    private Player player;

    public InGameState(){
        try {
            Textures.loadTexture("player.png");
            Textures.loadTexture("test1.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        spriteBox = new EntityBox(Textures.getNumTextures());
        player = new Player();
    }

    @Override
    public void update() {
        spriteBox.update();
        player.update();
    }

    @Override
    public void render() {
        Renderer.beginRender();
        spriteBox.render();
        player.render();
        Renderer.endRender();
    }

}
