package com.aedans.engine.sprites;

import com.aedans.engine.math.MatrixMath;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.TexturedModel;
import org.lwjgl.util.Renderable;
import org.lwjgl.util.vector.Matrix4f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Sprites that can be rendered by the Renderable.
 */

public abstract class Sprite implements Renderable {

    private TexturedModel texturedModel;
    private Point2D.Float position;

    public Sprite(float x, float y, TexturedModel texturedModel){
        this(new Point2D.Float(x, y), texturedModel);
    }

    public Sprite(Point2D.Float position, TexturedModel texturedModel){
        this.texturedModel = texturedModel;
        this.position = position;
    }

    public void render(){
        Renderer.compositeShader.loadTransformationMatrix(getTransformationMatrix());
        Renderer.loadTexturedModel(texturedModel);
        Renderer.drawElements();
    }

    public Point2D.Float getPosition(){
        return position;
    }

    public Matrix4f getTransformationMatrix(){
        return MatrixMath.createTransformationMatrix((float) position.getX(), (float) position.getY());
    }

    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    public abstract void update();


}
