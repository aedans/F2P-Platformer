package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.Sprite;
import com.aedans.engine.renderer.data.SpriteList;

/**
 * Created by Aedan Smith on 8/24/2016.
 *
 * Class containing all in-game sprites.
 */

public class SpriteBox extends SpriteList<Sprite> {

    /**
     * Default SpriteBox constructor.
     *
     * @param numTextures : The number of resources the SpriteList should support.
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

}
