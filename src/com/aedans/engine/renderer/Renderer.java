package com.aedans.engine.renderer;

import com.aedans.engine.renderer.shaders.CompositeShader;
import com.aedans.engine.renderer.shaders.Shader;
import org.lwjgl.opengl.GL11;

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
     * The current frame number.
     */
    private static int frameNum = 0;

    static {
        // Enables Transparency.
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    /**
     * Prepares the Renderer to render a frame.
     */
    public static void prepare() {
        // Clears the Display.
        GL11.glClearColor(0, 0, 0, 1);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        printf("Prepared frame %d", frameNum);
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
