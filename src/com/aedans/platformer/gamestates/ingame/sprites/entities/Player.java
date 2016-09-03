package com.aedans.platformer.gamestates.ingame.sprites.entities;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.collision.CollisionComponent;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.engine.entities.components.ADMovementComponent;
import com.aedans.engine.entities.components.GravityComponent;
import com.aedans.engine.renderer.Viewport;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The Player class for the game.
 */

public class Player extends Entity {

    public Player(EntityBox entityBox) {
        super(0, 0, TexturedModel.getTexturedModel(.12f, .12f, Textures.getTexture("player")));
        this.addComponent(new Component<Entity>() {
            @Override
            public void apply(Entity entity, long l) {
                Viewport.xVel = ((Viewport.x) - (getX()))*8;
                Viewport.yVel = ((Viewport.y) - (getY()))*8;
            }
        });
        this.addComponent(new ADMovementComponent(1.5f));
        this.addComponent(new CollisionComponent(entityBox));
        this.addComponent(new GravityComponent(entityBox, .035f));
        this.addComponent(new Component<Entity>() {
            @Override
            public void apply(Entity entity, long l) {
                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
                    CollisionDetails cd = entityBox.getCollision(Player.this);
                    if (cd != null && cd.getSide() == CollisionDetails.Side.TOP) {
                        entity.yVel += .02f;
                    }
                }
            }
        });
    }

}
