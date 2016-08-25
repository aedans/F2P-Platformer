package com.aedans.platformer.gamestates.ingame.sprites;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * A test Sprite to test the Renderer.
 */

public class TestEntity extends Entity {

    public TestEntity(float x, float y, String textureName) {
        super(x, y, TexturedModel.getTexturedModel(.1f, .1f, Textures.getTexture(textureName)));
    }

}
