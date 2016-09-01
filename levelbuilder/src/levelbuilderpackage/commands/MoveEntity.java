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

public class MoveEntity extends Command {

    private LBEntityList lbEntityList;

    public MoveEntity(LBEntityList lbEntityList) {
        super("mventity", "Moves an entity.");
        this.lbEntityList = lbEntityList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER, ArgumentType.INTEGER, ArgumentType.INTEGER);

        Entity e = lbEntityList.getEntities().get(Integer.parseInt(args.getArg(1).value));

        output.print("Moved entity \"" + e.toString() + "\"");

        e.setPosition(
                Integer.parseInt(args.getArg(2).value),
                Integer.parseInt(args.getArg(3).value)
        );

        output.println(" to " + Integer.parseInt(args.getArg(2).value) + ", " + Integer.parseInt(args.getArg(3).value));
    }

}
