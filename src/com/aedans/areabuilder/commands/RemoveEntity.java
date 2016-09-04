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

public class RemoveEntity extends Command {

    private Area area;

    public RemoveEntity(Area area) {
        super("rmentity");
        this.properties[0] = "Removes an entity.";
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER);

        Sprite s = area.getSprite(Integer.parseInt(args.get(1).value));

        area.removeSprite(s);

        output.println("Removed entity \"" + s.toString() + ", ID: " + Integer.parseInt(args.get(1).value) + "\"");
    }

}
