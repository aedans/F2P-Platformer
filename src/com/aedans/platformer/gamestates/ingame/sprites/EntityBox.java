package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.sprites.SpriteList;

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
     * Tests if an Entity is colliding with another Entity.
     *
     * @param e1: The Entity to test.
     * @return The Entity it is colliding with. Null if there is no colliding Entity.
     */
    public Entity getColliding(Entity e1){
        return this.iterate(e2 -> e1.getBoundingBox().intersects(e2.getBoundingBox()));
    }

}
