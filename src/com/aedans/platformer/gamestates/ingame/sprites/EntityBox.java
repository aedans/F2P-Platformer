package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.engine.sprites.SpriteList;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector2f;

import java.util.function.Function;

/**
 * Created by Aedan Smith on 8/24/2016.
 *
 * Class containing all in-game sprites.
 */

public class EntityBox extends SpriteList<Entity> {

    /**
     * Default EntityBox constructor.
     *
     * @param numTextures : The number of textures the EntityBox should support.
     */
    public EntityBox(int numTextures) {
        super(numTextures);
    }

    @Override
    protected void onAdd(Entity entity) {

    }

    @Override
    protected void onRemove(Entity entity) {

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
        Entity e2 = iterate(e21 -> {
            float e2hh = e21.getHeight() / 2, e2hw = e21.getWidth() / 2;
            return e1bot < e21.getY() + e2hh
                    && e1top > e21.getY() - e2hh
                    && e1right > e21.getX() - e2hw
                    && e1left < e21.getX() + e2hw;
        });
        if (e2 == null)
            return null;
        else {
            float xDist = e1.getX()-e2.getX(),
                    yDist = (e1.getY()-e2.getY())*(e2.getWidth()/e2.getHeight());
            if (xDist > yDist) {
                if (xDist > -yDist) {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.RIGHT);
                } else {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.BOTTOM);
                }
            } else {
                if (xDist > -yDist){
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.TOP);
                } else {
                    return new CollisionDetails(e1, e2, CollisionDetails.Side.LEFT);
                }
            }
        }
    }

}
