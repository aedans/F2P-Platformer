package com.aedans.engine.entities.collision;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.sprites.SpriteBox;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Component for adding Collisions to Entities.
 */

public class CollisionComponent implements Component<Entity> {

    /**
     * The SpriteBox containing the Entity.
     */
    private SpriteBox entityBox;

    /**
     * The CollisionDetails for the most recent Collision.
     */
    private CollisionDetails cd;

    /**
     * Default CollisionComponent constructor.
     *
     * @param entityBox The SpriteBox containing the Entity.
     */
    public CollisionComponent(SpriteBox entityBox) {
        this.entityBox = entityBox;
    }

    @Override
    public void apply(Entity entity, long l) {
        calculateCollisions(entity);
        if (cd != null) {
            entity.setPosition(cd.getCollisionX(), cd.getCollisionY());
            switch (cd.getSide()){
                case TOP:
                    if (entity.yVel < 0) entity.yVel = 0;
                    break;
                case BOTTOM:
                    if (entity.yVel > 0) entity.yVel = 0;
                    break;
                case LEFT:
                    if (entity.xVel > 0) entity.xVel = 0;
                    break;
                case RIGHT:
                    if (entity.xVel < 0) entity.xVel = 0;
                    break;
                default:
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
