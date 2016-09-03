package com.aedans.levelbuilder;

import com.aedan.jterminal.CommandPackage;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedans.engine.sprites.Sprite;
import com.aedans.levelbuilder.commands.ExportLevel;
import com.aedans.levelbuilder.commands.MakePlatform;
import com.aedans.levelbuilder.commands.MoveEntity;
import com.aedans.levelbuilder.commands.RemoveEntity;
import org.lwjgl.LWJGLException;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class LevelBuilderPackage implements CommandPackage {

    private ArrayList<Sprite> spriteList;

    public LevelBuilderPackage(ArrayList<Sprite> sprites) throws LWJGLException {
        this.spriteList = sprites;
    }

    @Override
    public void addCommands(CommandHandler commandHandler) {
        commandHandler.addCommand(new ExportLevel(spriteList));
        commandHandler.addCommand(new MakePlatform(spriteList));
        commandHandler.addCommand(new MoveEntity(spriteList));
        commandHandler.addCommand(new RemoveEntity(spriteList));
    }

}
