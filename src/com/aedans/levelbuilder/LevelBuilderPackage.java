package com.aedans.levelbuilder;

import com.aedan.jterminal.CommandPackage;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedans.engine.levels.Level;
import com.aedans.levelbuilder.commands.*;
import org.lwjgl.LWJGLException;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class LevelBuilderPackage implements CommandPackage {

    private Level level;

    public LevelBuilderPackage(Level level) throws LWJGLException {
        this.level = level;
    }

    @Override
    public void addCommands(CommandHandler commandHandler) {
        commandHandler.addCommand(new ExportLevel(level));
        commandHandler.addCommand(new LoadLevel(level));
        commandHandler.addCommand(new LoadTexture());
        commandHandler.addCommand(new MakePlatform(level));
        commandHandler.addCommand(new MoveEntity(level));
        commandHandler.addCommand(new RemoveEntity(level));
    }

}
