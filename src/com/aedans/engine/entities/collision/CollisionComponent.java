package com.aedans.engine.entities.collision;

import com.aedans.engine.entities.Component;
import com.aedans.engine.Entity;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding Collisions to Entities.
 */

public class CollisionComponent implements Component<Entity> {

    private EntityBox entityBox;

    public CollisionComponent(EntityBox entityBox){
        this.entityBox = entityBox;
    }

    @Override
    public void apply(Entity entity, long l) {
        CollisionDetails cd = entityBox.getCollision(entity);
        if (cd != null){
            entity.setPosition(cd.getCollisionX(), cd.getCollisionY());
            if (cd.getSide() == CollisionDetails.Side.TOP || cd.getSide() == CollisionDetails.Side.BOTTOM){
                entity.yVel = 0;
            }
            if (cd.getSide() == CollisionDetails.Side.LEFT || cd.getSide() == CollisionDetails.Side.RIGHT){
                entity.xVel = 0;
            }
        }
    }

}
