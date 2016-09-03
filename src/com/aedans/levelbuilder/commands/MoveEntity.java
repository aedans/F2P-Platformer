package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.sprites.Sprite;
import com.aedans.engine.sprites.SpriteList;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class MoveEntity extends Command {

    private ArrayList<Sprite> spriteList;

    public MoveEntity(ArrayList<Sprite> spriteList) {
        super("mventity");
        this.properties[0] = "Moves an entity.";
        this.spriteList = spriteList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER, ArgumentType.INTEGER, ArgumentType.INTEGER);

        Sprite s = spriteList.get(Integer.parseInt(args.get(1).value));

        output.print("Moved entity \"" + s.toString() + "\"");

        s.setPosition(
                Integer.parseInt(args.get(2).value),
                Integer.parseInt(args.get(3).value)
        );

        output.println(" to " + Integer.parseInt(args.get(2).value) + ", " + Integer.parseInt(args.get(3).value));
    }

}
