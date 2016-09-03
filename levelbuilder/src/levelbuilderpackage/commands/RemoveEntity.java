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

public class RemoveEntity extends Command {

    private LBEntityList lbEntityList;

    public RemoveEntity(LBEntityList lbEntityList) {
        super("rmentity");
        this.properties[0] = "Removes an entity.";
        this.lbEntityList = lbEntityList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output) throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.INTEGER);

        Entity e = lbEntityList.getEntities().get(Integer.parseInt(args.get(1).value));

        lbEntityList.removeEntity(e);

        output.println("Removed entity \"" + e.toString() + ", ID: " + Integer.parseInt(args.get(1).value) + "\"");
    }

}
