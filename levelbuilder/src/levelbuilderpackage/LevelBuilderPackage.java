package levelbuilderpackage;

import com.aedan.jterminal.CommandPackage;
import com.aedan.jterminal.commands.CommandHandler;
import display.LBDisplay;
import levelbuilderpackage.commands.ExportLevel;
import levelbuilderpackage.commands.MakePlatform;
import levelbuilderpackage.commands.MoveEntity;
import levelbuilderpackage.commands.RemoveEntity;

/**
 * Created by Aedan Smith on 9/1/2016.
 */

public class LevelBuilderPackage implements CommandPackage {

    private LBDisplay lbDisplay;

    public LevelBuilderPackage(LBDisplay lbDisplay){
        this.lbDisplay = lbDisplay;
    }

    @Override
    public void addCommands(CommandHandler commandHandler) {
        commandHandler.addCommand(new ExportLevel(lbDisplay.getLbEntityList()));
        commandHandler.addCommand(new MakePlatform(lbDisplay.getLbEntityList()));
        commandHandler.addCommand(new MoveEntity(lbDisplay.getLbEntityList()));
        commandHandler.addCommand(new RemoveEntity(lbDisplay.getLbEntityList()));
    }

}
