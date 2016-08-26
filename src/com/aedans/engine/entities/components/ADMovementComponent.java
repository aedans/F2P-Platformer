package com.aedans.engine.entities.components;

import com.aedans.engine.entities.Component;
import com.aedans.engine.entities.Entity;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 8/25/2016.
 *
 * Class for adding WASD movement to an Entity.
 */

public class ADMovementComponent implements Component<Entity> {

    private long lastTranslated = System.currentTimeMillis();
    private float horizontalSpeed;

    public ADMovementComponent(float horizontalSpeed){
        this.horizontalSpeed = horizontalSpeed;
    }

    @Override
    public void apply(Entity entity) {
        float m = (float) (System.currentTimeMillis() - lastTranslated) / 1000;
        float xTranslation = 0;
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            xTranslation -= horizontalSpeed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)){
            xTranslation += horizontalSpeed;
        }
        entity.xVel = xTranslation * m;
        this.lastTranslated = System.currentTimeMillis();
    }

}
