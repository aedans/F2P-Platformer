package com.aedans.areabuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class ExportArea extends Command {

    private Area area;

    public ExportArea(Area area) {
        super("export");
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        output.println(area.toString());
    }

}
