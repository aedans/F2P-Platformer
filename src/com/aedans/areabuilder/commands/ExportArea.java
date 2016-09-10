package com.aedans.areabuilder.commands;

import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.environment.Directory;
import com.aedan.jterminal.environment.Environment;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.areas.Area;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Command to export an Area to a .area file.
 */

public class ExportArea extends Command {

    /**
     * The Area currently stored in memory.
     */
    private Area area;

    /**
     * Default ExportArea constructor.
     *
     * @param area The Area currently stored in memory.
     */
    public ExportArea(Area area) {
        super("export");
        this.properties[0] = "Exports an area to .area format.";
        this.properties[1] =
                "export: Exports an area to a .area format. Use export >> [string].area to create an area with name\n" +
                "[string]";
        this.area = area;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Environment environment, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        output.println(area.toString());
    }

}
