package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.entities.Entity;
import com.aedans.engine.levels.Level;
import com.aedans.engine.levels.LevelLoader;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;
import com.aedans.platformer.gamestates.ingame.sprites.TestEntity;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class LoadLevel extends Command {

    private Level level;

    public LoadLevel(Level level) {
        super("load");
        this.properties[0] = "Loads a level.";
        this.level = level;
        LevelLoader.addLoader(s -> {
            Matcher m = Pattern.compile("\\(([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\d+-.]+)\\)").matcher(s);
            if (m.find()) {
                return new Sprite(
                        Float.parseFloat(m.group(1)),
                        Float.parseFloat(m.group(2)),
                        TexturedModel.getTexturedModel(
                                Float.parseFloat(m.group(3)),
                                Float.parseFloat(m.group(4)),
                                Textures.getTexture("default")
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
            Level level = LevelLoader.load(directory.getFile(args.get(1).value));
            for (Sprite s : level.getSprites()){
                this.level.addSprite(s);
            }
            output.println("Loaded level.");
            output.println(level);
        } catch (IOException e) {
            throw new CommandHandler.CommandHandlerException(e.getMessage());
        }
    }

}
