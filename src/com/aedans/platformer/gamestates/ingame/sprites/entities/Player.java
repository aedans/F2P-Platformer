package com.aedans.platformer.gamestates.ingame.sprites.entities;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.components.WASDMovementComponent;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The Player class for the game.
 */

public class Player extends Entity {

    public Player() {
        super(0, 0, TexturedModel.getTexturedModel(.08f, .08f, Textures.getTexture("player")));
        this.addComponent(new WASDMovementComponent(1.5f, 0));
    }

}
