package com.aedans.levelbuilder.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class ExportLevel extends Command {

    private ArrayList<Sprite> spriteList;

    public ExportLevel(ArrayList<Sprite> spriteList) {
        super("export");
        this.spriteList = spriteList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        spriteList.forEach(output::println);
    }

}
