package com.aedans.engine.sprites;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.engine.sprites.Sprite;
import com.aedans.engine.sprites.SpriteList;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/24/2016.
 *
 * Class containing all in-game sprites.
 */

public class SpriteBox extends SpriteList<Sprite> {

    /**
     * Default SpriteBox constructor.
     *
     * @param numTextures : The number of textures the SpriteBox should support.
     */
    public SpriteBox(int numTextures) {
        super(numTextures);
    }

    @Override
    protected void onAdd(Sprite sprite) {

    }

    @Override
    protected void onRemove(Sprite sprite) {

    }

    @Override
    protected void onUpdate() {

    }

    @Override
    protected void onRender() {

    }

    /**
     * Tests the Collisions of an Entity.
     *
     * @param e1: The entity to test.
     * @return The CollisionDetails for the collision.
     */
    // TODO: Optimize
    public CollisionDetails getCollision(Entity e1) {
        float e1top = e1.getY() + e1.getHeight() / 2 + e1.yVel,
                e1bot = e1.getY() - e1.getHeight() / 2 + e1.yVel,
                e1left = e1.getX() - e1.getWidth() / 2 + e1.xVel,
                e1right = e1.getX() + e1.getWidth() / 2 + e1.xVel;
        ArrayList<Entity> es = new ArrayList<>();
        iterate(e -> {
            if (e.getClass() == Sprite.class)
                return false;
            float e2hh = e.getHeight() / 2, e2hw = e.getWidth() / 2;
            if (e1bot < e.getY() + e2hh
                    && e1top > e.getY() - e2hh
                    && e1right > e.getX() - e2hw
                    && e1left < e.getX() + e2hw)
                es.add((Entity) e);
            return false;
        });
        if (es.size() == 0)
            return null;
        else if (es.size() == 1) {
            Entity e2 = es.get(0);
            float xDist = e1.getX() - e2.getX(),
                    yDist = (e1.getY() - e2.getY()) * (e2.getWidth() / e2.getHeight());
            if (xDist >= yDist) {
                if (xDist > -yDist) {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.RIGHT);
                } else {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.BOTTOM);
                }
            } else {
                if (xDist >= -yDist) {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.TOP);
                } else {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.LEFT);
                }
            }
        } else {
            Entity e2 = es.get(0), e3 = es.get(1);
            CollisionDetails.Side side1, side2;
            float xDist = e1.getX() - e2.getX(),
                    yDist = (e1.getY() - e2.getY()) * (e2.getWidth() / e2.getHeight());
            if (xDist > yDist) {
                if (xDist > -yDist) {
                    side1 = CollisionDetails.Side.RIGHT;
                } else {
                    side1 = CollisionDetails.Side.BOTTOM;
                }
            } else {
                if (xDist > -yDist) {
                    side1 = CollisionDetails.Side.TOP;
                } else {
                    side1 = CollisionDetails.Side.LEFT;
                }
            }
            xDist = e1.getX() - e3.getX();
            yDist = (e1.getY() - e3.getY()) * (e3.getWidth() / e3.getHeight());
            if (xDist > yDist) {
                if (xDist > -yDist) {
                    side2 = CollisionDetails.Side.RIGHT;
                } else {
                    side2 = CollisionDetails.Side.BOTTOM;
                }
            } else {
                if (xDist > -yDist) {
                    side2 = CollisionDetails.Side.TOP;
                } else {
                    side2 = CollisionDetails.Side.LEFT;
                }
            }
            return new CollisionDetails(e1, e2, e3, side1, side2);
        }
    }

}
