package com.aedans.engine.sprites;

import com.aedans.engine.math.MatrixMath;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.Viewport;
import com.aedans.engine.renderer.resources.TexturedModel;
import org.lwjgl.util.Renderable;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Abstract class for Sprites that can be rendered by the Renderable.
 */

public abstract class Sprite implements Renderable {

    /**
     * The TexturedModel of the Sprite.
     */
    private TexturedModel texturedModel;

    /**
     * The position of the Sprite.
     */
    private float x, y;

    /**
     * Default Sprite constructor.
     *
     * @param x The x position of the Sprite.
     * @param y The y position of the Sprite.
     * @param texturedModel The TexturedModel of the Sprite.
     */
    public Sprite(float x, float y, TexturedModel texturedModel){
        this.x = x;
        this.y = y;
        this.texturedModel = texturedModel;
    }

    /**
     * The default render function for the Sprite.
     */
    @Override
    public void render(){
        Renderer.compositeShader.loadTransformationMatrix(getTransformationMatrix());
        Renderer.loadTexturedModel(texturedModel);
        Renderer.drawElements();
    }

    /**
     * Translates the Sprite.
     *
     * @param x The x amount to translate.
     * @param y The y amount to translate.
     */
    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Sets the position of the Sprite.
     *
     * @param x The x position of the Sprite.
     * @param y The y position of the Sprite.
     */
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth(){
        return texturedModel.getWidth();
    }

    public float getHeight(){
        return texturedModel.getHeight();
    }

    public Matrix4f getTransformationMatrix(){
        return MatrixMath.createTransformationMatrix(Viewport.getRelativePosition(x, y));
    }

    public TexturedModel getTexturedModel() {
        return texturedModel;
    }

    public abstract void update(long l);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "::" + x + "," + y + "," + getWidth() + "," + getHeight();
    }

}
