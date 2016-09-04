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

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class LoadArea extends Command {

    private Area area;

    public LoadArea(Area area) {
        super("loadarea");
        this.properties[0] = "Loads an area.";
        this.area = area;
        AreaLoader.addLoader(s -> {
            Matcher m = Pattern.compile("([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\w]+)").matcher(s);
            if (m.find()) {
                return new Sprite(
                        Float.parseFloat(m.group(1)),
                        Float.parseFloat(m.group(2)),
                        TexturedModel.getTexturedModel(
                                Float.parseFloat(m.group(3)),
                                Float.parseFloat(m.group(4)),
                                Textures.getTexture(m.group(5))
                        )
                ){
                    @Override
                    public void update(long l) {

                    }
                };
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
