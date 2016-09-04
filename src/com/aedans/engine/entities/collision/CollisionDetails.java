package com.aedans.engine.entities.collision;

import com.aedans.engine.entities.Entity;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Class for handling and retrieving collisions.
 */

public class CollisionDetails {

    /**
     * The Position of the Collision.
     */
    private float collisionX, collisionY;

    /**
     * The Side of the Collision.
     */
    private Side side;

    /**
     * Default CollisionDetails constructor for two colliding Entities.
     *
     * @param e1 The first colliding Entity.
     * @param e2 The second colliding Entity.
     * @param side The side of the second object that is Colliding.
     */
    public CollisionDetails(Entity e1, Entity e2, Side side){
        this.side = side;
        switch (side) {
            case TOP:
                collisionX = e1.getX();
                collisionY = (e1.getY() + e1.getHeight() / 2 + e2.getY() + e2.getHeight() / 2) / 2;
                break;
            case BOTTOM:
                collisionX = e1.getX();
                collisionY = (e1.getY() - e1.getHeight() / 2 + e2.getY() - e2.getHeight() / 2) / 2;
                break;
            case LEFT:
                collisionX = (e1.getX() - e1.getWidth() / 2 + e2.getX() - e2.getWidth() / 2) / 2;
                collisionY = e1.getY();
                break;
            case RIGHT:
                collisionX = (e1.getX() + e1.getWidth() / 2 + e2.getX() + e2.getWidth() / 2) / 2;
                collisionY = e1.getY();
                break;
            default:break;
        }
    }

    /**
     * Default CollisionDetails constructor for two colliding Entities.
     *
     * @param e1 The first colliding Entity.
     * @param e2 The second colliding Entity.
     * @param e3 The third colliding Entity.
     * @param side1 The side of the second object that is Colliding.
     * @param side2 The side of the third object that is Colliding.
     */
    public CollisionDetails(Entity e1, Entity e2, Entity e3, Side side1, Side side2){
        this.side = Side.MULTI;
        switch (side1) {
            case TOP:
                collisionY = (e1.getY() + e1.getHeight() / 2 + e2.getY() + e2.getHeight() / 2) / 2;
                break;
            case BOTTOM:
                collisionY = (e1.getY() - e1.getHeight() / 2 + e2.getY() - e2.getHeight() / 2) / 2;
                break;
            case LEFT:
                collisionX = (e1.getX() - e1.getWidth() / 2 + e2.getX() - e2.getWidth() / 2) / 2;
                break;
            case RIGHT:
                collisionX = (e1.getX() + e1.getWidth() / 2 + e2.getX() + e2.getWidth() / 2) / 2;
                break;
            default:break;
        }
        switch (side2) {
            case TOP:
                collisionY = (e1.getY() + e1.getHeight() / 2 + e3.getY() + e3.getHeight() / 2) / 2;
                break;
            case BOTTOM:
                collisionY = (e1.getY() - e1.getHeight() / 2 + e3.getY() - e3.getHeight() / 2) / 2;
                break;
            case LEFT:
                collisionX = (e1.getX() - e1.getWidth() / 2 + e3.getX() - e3.getWidth() / 2) / 2;
                break;
            case RIGHT:
                collisionX = (e1.getX() + e1.getWidth() / 2 + e3.getX() + e3.getWidth() / 2) / 2;
                break;
            default:break;
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
        TOP, BOTTOM, LEFT, RIGHT, MULTI
    }

}
