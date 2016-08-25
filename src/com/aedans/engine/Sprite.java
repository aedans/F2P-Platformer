package com.aedans.engine;

import com.aedans.engine.math.MatrixMath;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.TexturedModel;
import org.lwjgl.util.Renderable;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Sprites that can be rendered by the Renderable.
 */

public abstract class Sprite implements Renderable {

    private TexturedModel texturedModel;
    public float x, y;

    public Sprite(float x, float y, TexturedModel texturedModel){
        this.texturedModel = texturedModel;
        this.x = x;
        this.y = y;
    }

    public void render(){
        Renderer.compositeShader.loadTransformationMatrix(getTransformationMatrix());
        Renderer.loadTexturedModel(texturedModel);
        Renderer.drawElements();
    }

    public Matrix4f getTransformationMatrix(){
        return MatrixMath.createTransformationMatrix(x, y);
    }

    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    public abstract void update();


}
