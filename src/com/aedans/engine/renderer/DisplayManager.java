package com.aedans.engine.renderer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Aedan Smith on 5/23/2016.
 * <p>
 * The Display manager for the Game.
 */

public class DisplayManager {

    /**
     * The x and y resolution of the Display.
     */
    public static int xRes, yRes;

    /**
     * The FPS to cap the Display at.
     */
    private static int fpscap = Display.getDesktopDisplayMode().getFrequency() * 2;

    /**
     * Creates a display.
     *
     * @param xRes:       The x resolution of the Display.
     * @param yRes:       The y resolution of the Display.
     * @param fullscreen: True if the Display should initialize in fullscreen.
     * @param title:      The title of the display (as seen at the top)
     *                    TODO: Remove Display Title.
     * @throws LWJGLException If LWJGL could not initialize the Display.
     */
    public static void createDisplay(int xRes, int yRes, boolean fullscreen, String title) throws LWJGLException {
        DisplayManager.xRes = xRes;
        DisplayManager.yRes = yRes;

        ContextAttribs attributes = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);

        Display.setDisplayMode(new DisplayMode(xRes, yRes));
        Display.setResizable(false);
        Display.setFullscreen(fullscreen);
        Display.create(new PixelFormat(), attributes);
        Display.setTitle(title);
        Display.setVSyncEnabled(true);
        GL11.glViewport(0, 0, xRes, yRes);
        System.out.println(GL11.glGetString(GL11.GL_VERSION));
    }

    /**
     * @return if the user has requested to close the Display.
     */
    public static boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    /**
     * Updates the Display.
     */
    public static void updateDisplay() {
        Display.sync(fpscap);
        Display.update();
    }

    /**
     * Closes the Display.
     */
    public static void closeDisplay() {
        Display.destroy();
    }

}