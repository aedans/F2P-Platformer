package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.sprites.SpriteList;

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

}
