package com.aedans.areabuilder.commands;

import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.environment.Directory;
import com.aedan.jterminal.environment.Environment;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;
import com.aedans.engine.sprites.Sprite;

/**
 * Created by Aedan Smith on 9/1/2016.
 *
 * Command to remove an Entity given an id.
 */

public class RemoveEntity extends Command {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default RemoveEntity constructor.
     *
     * @param area The Area currently stored in memory.
     */
    public RemoveEntity(Area area) {
        super("rmentity");
        this.properties[0] = "Removes an entity.";
        this.properties[1] = "rmentity [int-id]: Removes Entity [int-id] from the Area.";
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Environment environment, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER);

        Sprite s = area.getSprite(Integer.parseInt(args.get(1).value));

        area.removeSprite(s);

        output.println("Removed entity \"" + s.toString() + ", ID: " + Integer.parseInt(args.get(1).value) + "\"");
    }

}
