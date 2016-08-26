package com.aedans.engine;

import com.aedans.engine.entities.Component;
import com.aedans.engine.sprites.Sprite;
import com.aedans.engine.renderer.resources.TexturedModel;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Entities that can be rendered by the Renderer.
 */

public abstract class Entity extends Sprite {

    private ArrayList<Component<Entity>> components = new ArrayList<>();
    public float xVel = 0, yVel = 0;

    public Entity(float x, float y, TexturedModel texturedModel) {
        super(x, y, texturedModel);
    }

    public void update(long l){
        for (Component<Entity> ec : components){
            ec.apply(this, l);
        }
        translate(xVel * ((float)l/10), yVel * ((float)l/10));
    }

    public void addComponent(Component<Entity> component){
        components.add(component);
    }

}
