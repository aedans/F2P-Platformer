package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class MakePlatform extends Command {

    private ArrayList<Sprite> spriteList;

    public MakePlatform(ArrayList<Sprite> spriteList) {
        super("mkplatform");
        this.properties[0] = "Creates a platform with the given x, y, width, and height.";
        this.spriteList = spriteList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT);

        Sprite s = new Sprite(
                Float.parseFloat(args.get(1).value),
                Float.parseFloat(args.get(2).value),
                TexturedModel.getTexturedModel(
                        Float.parseFloat(args.get(3).value),
                        Float.parseFloat(args.get(4).value),
                        Textures.getTexture("default")
                )) {
            @Override
            public void update(long l) {

            }
        };

        spriteList.add(s);

        output.println("Added platform: " + s.toString());
    }

}
