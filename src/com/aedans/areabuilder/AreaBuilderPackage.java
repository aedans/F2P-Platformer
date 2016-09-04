package com.aedans.areabuilder;

import com.aedan.jterminal.CommandPackage;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedans.engine.areas.Area;
import com.aedans.areabuilder.commands.*;
import org.lwjgl.LWJGLException;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class AreaBuilderPackage implements CommandPackage {

    private Area area;

    public AreaBuilderPackage(Area area) throws LWJGLException {
        this.area = area;
    }

    @Override
    public void addCommands(CommandHandler commandHandler) {
        commandHandler.addCommand(new ExportArea(area));
        commandHandler.addCommand(new LoadArea(area));
        commandHandler.addCommand(new LoadTexture());
        commandHandler.addCommand(new MakePlatform(area));
        commandHandler.addCommand(new MoveEntity(area));
        commandHandler.addCommand(new RemoveEntity(area));
    }

}
