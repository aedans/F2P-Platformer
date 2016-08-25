package com.aedans.engine.renderer;

import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.shaders.CompositeShader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.io.PrintStream;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The main Renderer class.
 */

public class Renderer {

    /**
     * The output for the Renderer.
     */
    private static PrintStream output;

    /**
     * The CompositeShader for the Renderer.
     */
    public static CompositeShader compositeShader = new CompositeShader();

    /**
     * The current Model and Texture bound to the Renderer.
     */
    private static int currentModelID = -256, currentTextureID = -256;

    /**
     * The current frame number.
     */
    private static int frameNum = 0;

    static {
        // Enables Transparency.
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL13.glActiveTexture(GL13.GL_TEXTURE0);
    }

    /**
     * Prepares the Renderer to render a frame.
     */
    public static void beginRender() {
        // Clears the Display.
        GL11.glClearColor(0, 0, 0, 1);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        compositeShader.start();
        printf("Began rendering frame %d", frameNum);
    }

    /**
     * Ends the rendering of a frame.
     */
    public static void endRender(){
        compositeShader.stop();
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        printf("Finished rendering frame %d", frameNum);
        frameNum++;
    }

    /**
     * Loads a TexturedModel into OpenGL.
     *
     * @param texturedModel: The TexturedModel to load.
     */
    public static void loadTexturedModel(TexturedModel texturedModel){
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        if (texturedModel.getModelID() != currentModelID) {
            GL30.glBindVertexArray(texturedModel.getModelID());
            printf("Loaded Model %d", texturedModel.getModelID());
            currentModelID = texturedModel.getModelID();
        }
        if (texturedModel.getTextureID() != currentTextureID) {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTextureID());
            printf("Loaded Texture %d", texturedModel.getTextureID());
            currentTextureID = texturedModel.getTextureID();
        }
    }

    /**
     * Draws the currently bound elements.
     */
    public static void drawElements() {
        GL11.glDrawElements(GL11.GL_TRIANGLES, 8, GL11.GL_UNSIGNED_INT, 0);
        printf("Drew elements");
    }

    public static void cleanUp(){
        compositeShader.cleanUp();
        printf("Cleaned up Composite Shader.");
    }

    /**
     * Sets the Loader output to a given PrintStream.
     *
     * @param printStream: The PrintStream to print to.
     */
    public static void setOutput(PrintStream printStream){
        output = printStream;
    }

    private static void printf(String s, Object... args){
        if (output != null) {
            output.printf(s + "\n", args);
        }
    }

}
