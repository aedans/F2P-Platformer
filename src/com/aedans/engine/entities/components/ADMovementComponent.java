package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Class for adding AD movement to an Entity.
 */

public class ADMovementComponent implements Component<Entity> {

    /**
     * The horizontal speed of movement.
     */
    private float horizontalSpeed;

    /**
     * The default ADMovementComponent constructor.
     *
     * @param horizontalSpeed The horizontal speed of movement.
     */
    public ADMovementComponent(float horizontalSpeed){
        this.horizontalSpeed = horizontalSpeed;
    }

    @Override
    public void apply(Entity entity, long l) {
        if (Keyboard.isKeyDown(Keyboard.KEY_A)){
            entity.xVel -= Math.abs(entity.xVel+horizontalSpeed)/5;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_D)){
            entity.xVel += Math.abs(entity.xVel-horizontalSpeed)/5;
        }

        entity.xVel *= .8;
    }

}
