package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding gravity to an Entity.
 */

public class GravityComponent implements Component<Entity> {

    private EntityBox entityBox;
    private float weight;

    public GravityComponent(EntityBox entityBox, float weight) {
        this.entityBox = entityBox;
        this.weight = weight;
    }

    @Override
    public void apply(Entity entity) {
//        CollisionDetails cd = entityBox.getCollision(entity);
//        if (cd != null){
//            entity.yVel = 0;
//            entity.setPosition(entity.getX(), cd.getCollisionY());
//            return;
//        }
//        entity.yVel -= weight;
    }

}
