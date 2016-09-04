package com.aedans.platformer.gamestates.ingame.sprites.entities;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.sprites.SpriteBox;
import com.aedans.engine.entities.collision.CollisionComponent;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.engine.entities.components.ADMovementComponent;
import com.aedans.engine.entities.components.GravityComponent;
import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Viewport;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The Player class for the game.
 */

public class Player extends Entity {

    private CollisionComponent collisionComponent;
    private float jumpSpeed = .02f;
    private boolean isOnFloor = false;
    private int airJumpsLeft = 0, numAirJumps = 1;

    public Player(SpriteBox entityBox) {
        super(0, 0, TexturedModel.getTexturedModel(.12f, .12f, Textures.getTexture("player")));
        Viewport.setPosition(getX(), getY());
        this.addComponent(new Component<Entity>() {
            @Override
            public void apply(Entity entity, long l) {
                Viewport.xVel = ((Viewport.x) - (getX()))*8;
                Viewport.yVel = ((Viewport.y) - (getY()))*8;
                if (entity.getY() < -2)
                    reset();
                if (collisionComponent.getCollisionDetails() != null
                        && collisionComponent.getCollisionDetails().getSide() == CollisionDetails.Side.TOP){
                    isOnFloor = true;
                    airJumpsLeft = numAirJumps;
                } else {
                    isOnFloor = false;
                }
            }
        });
        this.addComponent(new ADMovementComponent(1.5f));
        this.addComponent(new GravityComponent(entityBox, .035f));
        this.addComponent(collisionComponent = new CollisionComponent(entityBox));
        this.addComponent(new Component<Entity>() {
            private int jumpTimer = 0;

            @Override
            public void apply(Entity entity, long l) {
                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && jumpTimer <= 0) {
                    if (isOnFloor){
                        entity.yVel = jumpSpeed;
                        jumpTimer = DisplayManager.getFPScap()/4;
                    } else if (airJumpsLeft != 0){
                        entity.yVel = jumpSpeed;
                        airJumpsLeft--;
                        jumpTimer = DisplayManager.getFPScap()/4;
                    }
                }
                jumpTimer--;
            }
        });
    }

    private void reset() {
        this.setPosition(0, 0);
        Viewport.setPosition(0, 0);
        this.xVel = 0;
        this.yVel = 0;
    }

    public void increaseNumAirJumps(){
        this.numAirJumps++;
    }

}
