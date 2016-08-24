package com.aedans.engine;

import com.aedans.engine.math.MatrixMath;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.data.TexturedModel;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
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
        Renderer.compositeShader.start();
        Renderer.compositeShader.loadTransformationMatrix(MatrixMath.createTransformationMatrix(x, y));
        GL30.glBindVertexArray(texturedModel.getModelID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTextureID());
        GL11.glDrawElements(GL11.GL_TRIANGLES, 8, GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        Renderer.compositeShader.stop();
    }

}
