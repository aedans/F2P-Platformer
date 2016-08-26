package com.aedans.engine.entities.collision;

import com.aedans.engine.entities.Entity;

/**
 * Created by Aedan Smith on 8/25/2016.
 */

public class CollisionDetails {

    private Entity e1, e2;
    private float collisionX, collisionY;
    private Side side;

    public CollisionDetails(Entity e1, Entity e2, Side side){
        this.e1 = e1;
        this.e2 = e2;
        this.side = side;
        switch (side) {
            case TOP:
                collisionX = e1.getX();
                collisionY = (e1.getY() + e1.getHeight() / 2 + e2.getY() + e2.getHeight() / 2) / 2 - e1.yVel;
                break;
            case BOTTOM:
                collisionX = e1.getX();
                collisionY = (e1.getY() - e1.getHeight() / 2 + e2.getY() - e2.getHeight() / 2) / 2 - e1.yVel;
                break;
            case LEFT:
                collisionX = (e1.getX() - e1.getWidth() / 2 + e2.getX() - e2.getWidth() / 2) / 2 - e1.xVel;
                collisionY = e1.getY();
                break;
            case RIGHT:
                collisionX = (e1.getX() + e1.getWidth() / 2 + e2.getX() + e2.getWidth() / 2) / 2 - e1.xVel;
                collisionY = e1.getY();
                break;
        }
    }

    public float getCollisionX() {
        return collisionX;
    }

    public float getCollisionY() {
        return collisionY;
    }

    public Side getSide() {
        return side;
    }

    public enum Side {
        TOP, BOTTOM, LEFT, RIGHT
    }

}
