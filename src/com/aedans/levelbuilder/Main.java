package com.aedans.levelbuilder;

import com.aedan.jterminal.JTerminal;
import com.aedan.jterminal.commands.defaultpackage.DefaultPackage;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.levels.Level;
import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.Textures;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aedan Smith on 8/31/2016.
 *
 * Main class for the Level Builder.
 */

public class Main {

    private static Level level = new Level(new ArrayList<>());

    public static void main(String[] args) throws Exception {
        DisplayManager.createDisplay(900, 900, false, "Level Editor");
        Textures.loadTexture("default.png");
        new JTerminal(
                "-directory assets/levels",
                new OpenGLCommandInput(level),
                new CommandOutput(),
                new DefaultPackage(),
                new LevelBuilderPackage(level)
        ).run();
    }

    private static class OpenGLCommandInput implements CommandInput {

        private Level level;

        public OpenGLCommandInput(Level level) {
            this.level = level;
        }

        public String nextLine() {
            try {
                while (System.in.available() == 0) {
                    if (DisplayManager.isCloseRequested())
                        System.exit(0);
                    DisplayManager.updateDisplay();
                    Renderer.beginRender();
                    level.render();
                    Renderer.endRender();
                }
                byte[] bs = new byte[System.in.available()];
                System.in.read(bs);
                bs = Arrays.copyOf(bs, bs.length - 1);
                return new String(bs);
            } catch (Exception e) {
                e.printStackTrace();
                return "broken";
            }
        }

    }

}
