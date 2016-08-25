package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Class for adding WASD movement to an Entity.
 */

public class WASDMovementComponent implements Component<Entity> {

    private long lastTranslated = System.currentTimeMillis();
    private float horizontalSpeed, verticalSpeed;

    public WASDMovementComponent(float horizontalSpeed, float verticalSpeed){
        this.horizontalSpeed = horizontalSpeed;
        this.verticalSpeed = verticalSpeed;
    }

    @Override
    public void apply(Entity entity) {
        float m = (float) (System.currentTimeMillis() - lastTranslated) / 1000;
        float xTranslation = 0, yTranslation = 0;
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            xTranslation -= horizontalSpeed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)){
            xTranslation += horizontalSpeed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W)){
            yTranslation += verticalSpeed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)){
            yTranslation -= verticalSpeed;
        }
        entity.getPosition().setLocation(
                entity.getPosition().getX() + xTranslation * m,
                entity.getPosition().getY() + yTranslation * m
        );
        this.lastTranslated = System.currentTimeMillis();
    }

}
