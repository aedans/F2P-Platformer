package levelbuilderpackage.commands;

import com.aedan.jterminal.Directory;
import com.aedan.jterminal.commands.Command;
import com.aedan.jterminal.commands.CommandHandler;
import com.aedan.jterminal.commands.commandarguments.ArgumentType;
import com.aedan.jterminal.commands.commandarguments.CommandArgumentList;
import com.aedan.jterminal.input.CommandInput;
import com.aedan.jterminal.output.CommandOutput;
import com.aedan.jterminal.utils.FileUtils;
import display.entities.LBEntityList;

import java.io.File;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class ExportLevel extends Command {

    private LBEntityList lbEntityList;

    public ExportLevel(LBEntityList lbEntityList) {
        super("export");
        this.lbEntityList = lbEntityList;
    }

    @Override
    public void parse(CommandInput input, CommandArgumentList args, Directory directory, CommandOutput output)
            throws CommandHandler.CommandHandlerException {
        args.checkMatches(ArgumentType.STRING);

        try {
            output.println(FileUtils.writeToFile(new File(args.get(1).value), lbEntityList.toString()));
        } catch (FileUtils.FileIOException e) {
            throw new CommandHandler.CommandHandlerException(e.getMessage());
        }
    }

}
