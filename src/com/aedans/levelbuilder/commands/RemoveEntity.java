package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class RemoveEntity extends Command {

    private ArrayList<Sprite> spriteList;

    public RemoveEntity(ArrayList<Sprite> spriteList) {
        super("rmentity");
        this.properties[0] = "Removes an entity.";
        this.spriteList = spriteList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER);

        Sprite s = spriteList.get(Integer.parseInt(args.get(1).value));

        spriteList.remove(s);

        output.println("Removed entity \"" + s.toString() + ", ID: " + Integer.parseInt(args.get(1).value) + "\"");
    }

}