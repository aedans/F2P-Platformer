package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.Sprite;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * A test Sprite to test the Renderer.
 */

public class TestSprite extends Sprite {

    public TestSprite(float x, float y, String textureName) {
        super(x, y, TexturedModel.getTexturedModel(.1f, .1f, Textures.getTexture(textureName)));
    }

    @Override
    public void update() {

    }

}
