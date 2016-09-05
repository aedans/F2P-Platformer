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
    private int airDashesLeft = 0, numAirDashes = 1;

    public Player(SpriteBox entityBox) {
        super(0, 0, TexturedModel.getTexturedModel(.12f, .12f, Textures.getTexture("player")));
        Viewport.setPosition(getX(), getY());
        this.addComponent(new MovementComponent());
        this.addComponent(new ADMovementComponent(0.035f));
        this.addComponent(new GravityComponent(entityBox, .035f));
        this.addComponent(collisionComponent = new CollisionComponent(entityBox));
        this.addComponent((entity, l) -> {
            Viewport.xVel = (Viewport.x - getX()) * 8;
            Viewport.yVel = (Viewport.y - getY()) * 8;
        });
    }

    private class MovementComponent implements Component<Player> {

        private ADMovementComponent movementComponent = new ADMovementComponent(0.035f);
        private NormalMovementComponent normalMovementComponent = new NormalMovementComponent();
        private DashMovementComponent dashMovementComponent = new DashMovementComponent();

        private int jumpTimer = 0;
        private int movementType = 0;

        @Override
        public void apply(Player player, long l) {
            switch (movementType){
                case 0:
                    normalMovementComponent.apply(player, l);
                    break;
                case 1:
                    dashMovementComponent.apply(player, l);
                    break;
                default:
                    movementComponent.apply(player, l);
            }
            if (player.getY() < -2)
                player.reset();
        }

        private class NormalMovementComponent implements Component<Player> {
            @Override
            public void apply(Player player, long l) {
                if (collisionComponent.getCollisionDetails() != null
                        && collisionComponent.getCollisionDetails().getSide() == CollisionDetails.Side.TOP){
                    isOnFloor = true;
                    airDashesLeft = numAirDashes;
                } else {
                    isOnFloor = false;
                }

                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && jumpTimer <= 0) {
                    if (isOnFloor){
                        player.yVel = jumpSpeed;
                        jumpTimer = DisplayManager.getFPScap()/3;
                    } else if (airDashesLeft != 0){
                        movementType = 1;
                        dashMovementComponent.begin(20);
                        airDashesLeft--;
                        jumpTimer = DisplayManager.getFPScap()/3;
                    }
                }
                jumpTimer--;

                movementComponent.apply(player, l);
            }
        }

        private class DashMovementComponent implements Component<Player> {
            private boolean right, left, up, down;
            private int framesLeft;

            @Override
            public void apply(Player player, long l) {
                if (framesLeft == 0)
                    MovementComponent.this.movementType = 0;
                this.framesLeft--;
                if (right)
                    player.xVel = .03f;
                if (left)
                    player.xVel = -.03f;
                if (up)
                    player.yVel = .02f;
                if (down)
                    player.yVel = -.02f;
            }

            void begin(int length) {
                right = Keyboard.isKeyDown(Keyboard.KEY_D);
                left = Keyboard.isKeyDown(Keyboard.KEY_A);
                up = Keyboard.isKeyDown(Keyboard.KEY_W);
                down = Keyboard.isKeyDown(Keyboard.KEY_S);
                if (!up && !down && !left && !right)
                    up = true;
                framesLeft = length;
            }
        }

    }

    private void reset() {
        this.setPosition(0, 0);
        Viewport.setPosition(0, 0);
        this.xVel = 0;
        this.yVel = 0;
    }

    public void increaseNumAirJumps(){
        this.numAirDashes++;
    }

}
