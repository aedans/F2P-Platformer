package com.aedans.engine.entities;

import com.aedans.engine.Sprite;
import com.aedans.engine.renderer.data.TexturedModel;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Entities that can be rendered by the Renderable.
 */

public abstract class Entity extends Sprite {

    private ArrayList<EntityComponent> components = new ArrayList<>();

    public Entity(float x, float y, TexturedModel texturedModel) {
        super(x, y, texturedModel);
    }

    public void update(){
        for (EntityComponent ec : components){
            ec.update(this);
        }
    }

    public void addComponent(EntityComponent component){
        components.add(component);
    }

}
