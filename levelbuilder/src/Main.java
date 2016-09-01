import com.aedan.jtermgui.JTDisplay;
import com.aedan.jtermgui.JTPrintStream;
import com.aedan.jterminal.JTerminal;
import com.aedan.jterminal.commands.defaultpackage.DefaultPackage;
import com.aedan.jterminal.output.CommandOutput;
import display.LBDisplay;
import levelbuilderpackage.LevelBuilderPackage;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class Main {

    public static void main(String[] args){
        LBDisplay lbDisplay = new LBDisplay(900, 900);
        JTDisplay display = new JTDisplay(1280, 716);
        new JTerminal(
                "",
                display.getJTKeyListener(),
                new CommandOutput(new JTPrintStream(display.getJTStringList())),
                new DefaultPackage(),
                new LevelBuilderPackage(lbDisplay)
        ).run();
    }

}
