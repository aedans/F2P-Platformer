package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding gravity to an Entity.
 */

public class GravityComponent implements Component<Entity> {

    private EntityBox entityBox;
    private float weight;
    private float yVel = 0;

    public GravityComponent(EntityBox entityBox, float weight) {
        this.entityBox = entityBox;
        this.weight = weight;
    }

    @Override
    public void apply(Entity entity) {
        Entity e = entityBox.getColliding(entity);
        if (e != null){
            if (e.getY() < entity.getY()-entity.getHeight()){
                yVel = 0;
                return;
            }
        }
        yVel -= weight;
        entity.translate(0, yVel);
    }

}
