package com.aedans.platformer.gamestates.ingame.sprites.entities;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.renderer.data.TexturedModel;
import com.aedans.engine.renderer.data.Textures;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The Player class for the game.
 */

public class Player extends Entity {

    public Player() {
        super(0, 0, TexturedModel.getTexturedModel(.08f, .08f, Textures.getTexture("player")));
        this.addComponent(entity -> {
            if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
                entity.x -= .01f;
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_D)){
                entity.x += .01f;
            }
        });
    }

}
