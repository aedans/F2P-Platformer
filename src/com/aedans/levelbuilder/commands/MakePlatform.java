package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.levels.Level;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class MakePlatform extends Command {

    private Level level;

    public MakePlatform(Level level) {
        super("mkplatform");
        this.properties[0] = "Creates a platform with the given x, y, width, and height.";
        this.level = level;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.STRING);

        Sprite s = new Platform(
                Float.parseFloat(args.get(1).value),
                Float.parseFloat(args.get(2).value),
                TexturedModel.getTexturedModel(
                        Float.parseFloat(args.get(3).value),
                        Float.parseFloat(args.get(4).value),
                        Textures.getTexture(args.get(5).value)
                ),
                args.get(5).value
        );

        level.addSprite(s);

        output.println("Added " + s.toString());
    }

    private static class Platform extends Sprite {

        private String texture;

        public Platform(float x, float y, TexturedModel texturedModel, String texture) {
            super(x, y, texturedModel);
            this.texture = texture;
        }

        @Override
        public void update(long l) {

        }

        @Override
        public String toString() {
            return super.toString() + "," + texture;
        }

    }

}
