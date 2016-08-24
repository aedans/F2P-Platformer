package com.aedans.engine.renderer;

import com.aedans.engine.renderer.shaders.CompositeShader;
import com.aedans.engine.renderer.shaders.Shader;
import org.lwjgl.opengl.GL11;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The main Renderer class.
 */

public class Renderer {

    public static CompositeShader compositeShader = new CompositeShader();

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
    }

}
