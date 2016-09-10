package com.aedans.areabuilder.commands;

import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.environment.Directory;
import com.aedan.jterminal.environment.Environment;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Command to load a Texture into the Area Builder.
 */

public class LoadTexture extends Command {

    /**
     * Default LoadTexture constructor.
     */
    public LoadTexture() {
        super("loadtexture");
        properties[0] = "Loads a Texture into OpenGL";
        properties[1] = "loadtexture [string]: Loads texture [string] into OpenGL";
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Environment environment, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.STRING);

        try {
            Textures.loadTexture(args.get(1).value);
            output.println("Loaded texture " + args.get(1));
        } catch (Exception e) {
            throw new CommandHandler.CommandHandlerException(e.getMessage());
        }
    }

}
