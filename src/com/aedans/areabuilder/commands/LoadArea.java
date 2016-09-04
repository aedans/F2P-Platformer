package com.aedans.areabuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;
import com.aedans.engine.areas.AreaLoader;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Platform;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Command to load an Area from a .area file.
 */

public class LoadArea extends Command {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default LoadArea constructor.
     *
     * @param area The Area currently stored in memory.
     */
    public LoadArea(Area area) {
        super("loadarea");
        this.properties[0] = "Loads an area.";
        this.properties[1] = "loadarea [string]: Loads file [string].area into memory";
        this.area = area;
        AreaLoader.addLoader(s -> {
            Matcher m = Pattern.compile("(\\w+)::([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\w]+)").matcher(s);
            if (m.find()) {
                switch (m.group(1)){
                    case "Platform":
                        return new Platform(
                                Float.parseFloat(m.group(2)),
                                Float.parseFloat(m.group(3)),
                                Float.parseFloat(m.group(4)),
                                Float.parseFloat(m.group(5)),
                                m.group(6)
                        );
                    default:
                        return new Sprite(
                                Float.parseFloat(m.group(2)),
                                Float.parseFloat(m.group(3)),
                                TexturedModel.getTexturedModel(
                                        Float.parseFloat(m.group(4)),
                                        Float.parseFloat(m.group(5)),
                                        Textures.getTexture(m.group(6))
                                )
                        ){
                            @Override
                            public void update(long l) {

                            }
                        };
                }
            } else {
                return null;
            }
        });
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.STRING);

        try {
            Area area = AreaLoader.load(directory.getFile(args.get(1).value + ".area"));
            for (Sprite s : area.getSprites()){
                this.area.addSprite(s);
            }
            output.println("Loaded area.");
            output.println(area);
        } catch (IOException e) {
            throw new CommandHandler.CommandHandlerException(e.getMessage());
        }
    }

}
