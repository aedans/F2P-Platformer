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
 *
 * Command to move an Entity given an id.
 */

public class MoveEntity extends Command {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default MoveEntity constructor.
     *
     * @param area The Area currently stored in memory.
     */
    public MoveEntity(Area area) {
        super("mventity");
        this.properties[0] = "Moves an entity.";
        this.properties[1] = "mventity [int-id] [float-x] [float-y]: Translates Entity [id] over [float-x], [float-y]";
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
