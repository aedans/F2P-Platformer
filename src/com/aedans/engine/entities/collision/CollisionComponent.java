package com.aedans.engine.entities.collision;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.entities.EntityBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding Collisions to Entities.
 */

public class CollisionComponent implements Component<Entity> {

    /**
     * The EntityBox containing the Entity.
     */
    private EntityBox entityBox;

    /**
     * The CollisionDetails for the most recent Collision.
     */
    private CollisionDetails cd;

    /**
     * Default CollisionComponent constructor.
     *
     * @param entityBox The EntityBox containing the Entity.
     */
    public CollisionComponent(EntityBox entityBox) {
        this.entityBox = entityBox;
    }

    @Override
    public void apply(Entity entity, long l) {
        calculateCollisions(entity);
        if (cd != null) {
            entity.setPosition(cd.getCollisionX(), cd.getCollisionY());
            if (cd.getSide() == CollisionDetails.Side.TOP || cd.getSide() == CollisionDetails.Side.BOTTOM) {
                entity.yVel = 0;
            }
            if (cd.getSide() == CollisionDetails.Side.LEFT || cd.getSide() == CollisionDetails.Side.RIGHT) {
                entity.xVel = 0;
            }
            if (cd.getSide() == CollisionDetails.Side.MULTI) {
                entity.xVel = 0;
                entity.yVel = 0;
            }
        }
    }

    public void calculateCollisions(Entity e){
        this.cd = entityBox.getCollision(e);
    }

    public CollisionDetails getCollisionDetails() {
        return cd;
    }

}
