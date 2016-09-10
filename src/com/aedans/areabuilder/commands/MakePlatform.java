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
import com.aedans.platformer.gamestates.ingame.sprites.entities.Platform;

/**
 * Created by Aedan Smith on 9/1/2016.
 *
 * Command to create a Platform in a given Area.
 */

public class MakePlatform extends Command {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default MakePlatform constructor.
     *
     * @param area The Area currently stored in memory.
     */
    public MakePlatform(Area area) {
        super("mkplatform");
        this.properties[0] = "Creates a platform with the given x, y, width, height, and Texture.";
        this.properties[1] =
                "mkplatform [float-x] [float-y] [float-width] [float-height] [string]: Creates a Platform with the\n" +
                "position ([float-x], [float-y]), width [float-width], height [float-height], and texture [string].";
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Environment environment, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.FLOAT, ArgumentType.STRING);

        Sprite s = new Platform(
                Float.parseFloat(args.get(1).value),
                Float.parseFloat(args.get(2).value),
                Float.parseFloat(args.get(3).value),
                Float.parseFloat(args.get(4).value),
                args.get(5).value
        );

        area.addSprite(s);

        output.println("Added " + s.toString());
    }

}
