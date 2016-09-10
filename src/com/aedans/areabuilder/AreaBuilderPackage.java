package com.aedans.areabuilder;

import com.aedan.jterminal.commands.CommandPackage;
import com.aedan.jterminal.environment.Environment;
import com.aedans.engine.areas.Area;
import com.aedans.areabuilder.commands.*;
import org.lwjgl.LWJGLException;

/**
 * Created by Aedan Smith on 9/1/2016.
 *
 * The Package for the Area Builder.
 */

class AreaBuilderPackage implements CommandPackage {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default AreaBuilderPackage constructor.
     *
     * @param area The Area currently stored in memory.
     */
    AreaBuilderPackage(Area area) throws LWJGLException {
        this.area = area;
    }

    @Override
    public void addCommands(Environment environment) {
        environment.addCommand(new ExportArea(area));
        environment.addCommand(new LoadArea(area));
        environment.addCommand(new LoadTexture());
        environment.addCommand(new MakePlatform(area));
        environment.addCommand(new MoveEntity(area));
        environment.addCommand(new RemoveEntity(area));
    }

}
