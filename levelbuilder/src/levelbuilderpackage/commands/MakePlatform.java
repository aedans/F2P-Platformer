package levelbuilderpackage.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import display.entities.Entity;
import display.entities.LBEntityList;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class MakePlatform extends Command {

    private LBEntityList lbEntityList;

    public MakePlatform(LBEntityList lbEntityList) {
        super("mkplatform", "Creates a platform with the given x, y, width, and height.");
        this.lbEntityList = lbEntityList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER, ArgumentType.INTEGER, ArgumentType.INTEGER, ArgumentType.INTEGER);

        Entity e = new Entity(
                Integer.parseInt(args.getArg(1).value),
                Integer.parseInt(args.getArg(2).value),
                Integer.parseInt(args.getArg(3).value),
                Integer.parseInt(args.getArg(4).value)
        );

        int id = lbEntityList.addEntity(e);

        output.println("Added platform: \"" + e.toString() + ", ID: " + id + "\"");
    }

}
