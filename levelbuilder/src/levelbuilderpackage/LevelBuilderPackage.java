package levelbuilderpackage;

import com.aedan.jterminal.CommandPackage;
import com.aedan.jterminal.commands.CommandHandler;
import display.LBDisplay;
import levelbuilderpackage.commands.MakePlatform;

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
        commandHandler.addCommand(new MakePlatform(lbDisplay.getLbEntityList()));
    }

}
