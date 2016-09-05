package com.aedans.areabuilder;

import com.aedan.jterminal.JTerminal;
import com.aedan.jterminal.commands.defaultpackage.DefaultPackage;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.input.SystemInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;
import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Loader;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.Viewport;
import com.aedans.engine.renderer.resources.Textures;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aedan Smith on 8/31/2016.
 *
 * Main class for the Area Builder.
 */

public class Main {

    /**
     * The Area currently being developed.
     */
    private static Area level = new Area(new ArrayList<>());

    /**
     * Main function for the AreaBuilder.
     *
     * @param args The arguments for the AreaBuilder.
     * @throws Exception if there is an error initializing the LevelBuilder.
     */
    public static void main(String[] args) throws Exception {
        DisplayManager.createDisplay(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false, "AreaBuilder");
        Textures.loadTexture("default.png");
        new JTerminal(
                "-directory assets/area -startup assets/area/startup.jterm",
                new OpenGLCommandInput(),
//                new SystemInput(),
                new CommandOutput(),
                new DefaultPackage(),
                new AreaBuilderPackage(level)
        ).run();
        Loader.cleanUp();
        Renderer.cleanUp();
    }

    /**
     * The CommandInput for the AreaBuilder.
     */
    private static class OpenGLCommandInput implements CommandInput {

        private Scanner scanner = new Scanner(System.in);

        public String nextLine() {
            try {
                while (System.in.available() == 0) {
                    if (Keyboard.isKeyDown(Keyboard.KEY_D))
                        Viewport.xVel = -1f;
                    else if (Keyboard.isKeyDown(Keyboard.KEY_A))
                        Viewport.xVel = 1f;
                    else Viewport.xVel = 0;

                    if (Keyboard.isKeyDown(Keyboard.KEY_W))
                        Viewport.yVel = -1f;
                    else if (Keyboard.isKeyDown(Keyboard.KEY_S))
                        Viewport.yVel = 1f;
                    else Viewport.yVel = 0;

                    Viewport.update();

                    if (DisplayManager.isCloseRequested())
                        System.exit(0);

                    DisplayManager.updateDisplay();
                    Renderer.beginRender();
                    level.render();
                    Renderer.endRender();
                }
                return scanner.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "broken";
            } catch (Exception e){
                e.printStackTrace();
                Loader.cleanUp();
                Renderer.cleanUp();
                System.exit(-1);
                return "exit";
            }
        }

    }

}
