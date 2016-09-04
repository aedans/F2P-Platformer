package com.aedans.areabuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;
import com.aedans.engine.sprites.Sprite;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class MoveEntity extends Command {

    private Area area;

    public MoveEntity(Area area) {
        super("mventity");
        this.properties[0] = "Moves an entity.";
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER, ArgumentType.FLOAT, ArgumentType.FLOAT);

        Sprite s = area.getSprite(Integer.parseInt(args.get(1).value));

        output.print("Moved entity \"" + s.toString() + "\"");

        s.translate(
                Float.parseFloat(args.get(2).value),
                Float.parseFloat(args.get(3).value)
        );

        output.println(" to " + s.getX() + ", " + s.getY());
    }

}
