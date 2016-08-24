package com.aedans.engine;

import com.aedans.engine.math.MatrixMath;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.data.TexturedModel;
import org.lwjgl.util.Renderable;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Sprites that can be rendered by the Renderable.
 */

public abstract class Sprite implements Renderable {

    private TexturedModel texturedModel;
    private float x, y;

    public Sprite(float x, float y, TexturedModel texturedModel){
        this.texturedModel = texturedModel;
        this.x = x;
        this.y = y;
    }

    public void render(){
        Renderer.compositeShader.loadTransformationMatrix(MatrixMath.createTransformationMatrix(x, y));
        Renderer.loadTexturedModel(texturedModel);
        Renderer.drawElements();
    }

}
