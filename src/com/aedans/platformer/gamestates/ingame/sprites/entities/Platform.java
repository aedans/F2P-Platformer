package com.aedans.platformer.gamestates.ingame.sprites.entities;

import com.aedans.engine.entities.Entity;

/**
 * Created by Aedan Smith on 9/4/2016.
 */

public class Platform extends Entity {

    private String texture;

    public Platform(float x, float y, float width, float height, String texture) {
        super(x, y, width, height, texture);
        this.texture = texture;
    }

    @Override
    public void update(long l) {

    }

    @Override
    public String toString() {
        return super.toString() + "," + texture;
    }

}