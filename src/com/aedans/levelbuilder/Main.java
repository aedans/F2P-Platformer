package com.aedans.levelbuilder;

import com.aedan.jterminal.JTerminal;
import com.aedan.jterminal.commands.defaultpackage.DefaultPackage;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aedan Smith on 8/31/2016.
 *
 * Main class for the Level Builder.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Sprite> sprites = new ArrayList<>();
        DisplayManager.createDisplay(900, 900, false, "Level Editor");
        Textures.loadTexture("default.png");
        new JTerminal(
                "",
                new OpenGLCommandInput(sprites),
                new CommandOutput(),
                new DefaultPackage(),
                new LevelBuilderPackage(sprites)
        ).run();
    }

    private static class OpenGLCommandInput implements CommandInput {

        private ArrayList<Sprite> sprites;

        public OpenGLCommandInput(ArrayList<Sprite> sprites) {
            this.sprites = sprites;
        }

        public String nextLine() {
            try {
                while (System.in.available() == 0) {
                    if (DisplayManager.isCloseRequested())
                        System.exit(0);
                    DisplayManager.updateDisplay();
                    Renderer.beginRender();
                    sprites.forEach(Sprite::render);
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
