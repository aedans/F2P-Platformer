package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.collision.CollisionDetails;
import com.aedans.engine.entities.EntityBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding gravity to an Entity.
 */

public class GravityComponent implements Component<Entity> {

    /**
     * The EntityBox that contains the Entity.
     */
    private EntityBox entityBox;

    /**
     * The weight of the Entity.
     */
    private float weight;

    /**
     * Default GravityComponent constructor.
     *
     * @param entityBox The EntityBox that contains the Entity.
     * @param weight The weight of the Entity.
     */
    public GravityComponent(EntityBox entityBox, float weight) {
        this.entityBox = entityBox;
        this.weight = weight / 1000;
    }

    @Override
    public void apply(Entity entity, long l) {
        CollisionDetails cd = entityBox.getCollision(entity);
        if (cd != null){
            if (cd.getSide() == CollisionDetails.Side.TOP) {
                entity.setPosition(cd.getCollisionX(), cd.getCollisionY());
                return;
            }
        }
        entity.yVel -= weight * l;
    }

}
