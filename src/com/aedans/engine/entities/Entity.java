package com.aedans.engine.entities;

import com.aedans.engine.sprites.Sprite;
import com.aedans.engine.renderer.resources.TexturedModel;
import javafx.geometry.BoundingBox;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Entities that can be rendered by the Renderer.
 */

public abstract class Entity extends Sprite {

    private ArrayList<Component<Entity>> components = new ArrayList<>();

    public Entity(float x, float y, TexturedModel texturedModel) {
        super(x, y, texturedModel);
    }

    public void update(){
        for (Component<Entity> ec : components){
            ec.apply(this);
        }
    }

    public void addComponent(Component<Entity> component){
        components.add(component);
    }

}
