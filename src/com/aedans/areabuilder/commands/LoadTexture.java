package com.aedans.areabuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.renderer.resources.Textures;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class LoadTexture extends Command {

    public LoadTexture() {
        super("loadtexture");
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.STRING);

        try {
            Textures.loadTexture(args.get(1).value);
        } catch (Exception e) {
            throw new CommandHandler.CommandHandlerException(e.getMessage());
        }
    }

}
