package com.aedans.engine.entities;

import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Entities that can be rendered by the Renderer.
 */

public abstract class Entity extends com.aedans.engine.sprites.Sprite {

    private ArrayList<Component<Entity>> components = new ArrayList<>();
    public float xVel = 0, yVel = 0;

    public Entity(float x, float y, TexturedModel texturedModel) {
        super(x, y, texturedModel);
    }

    public Entity(float x, float y, float width, float height, String texture){
        super(x, y, TexturedModel.getTexturedModel(width, height, Textures.getTexture(texture)));
    }

    public void update(long l){
        for (Component<Entity> ec : components){
            ec.apply(this, l);
        }
        translate(xVel * ((float)l/10), yVel * ((float)l/10));
    }

    public void addComponent(Component<? extends Entity> component){
        //noinspection unchecked
        components.add((Component<Entity>) component);
    }

}
