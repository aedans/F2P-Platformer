import com.aedans.engine.renderer.DisplayManager;
import com.aedans.engine.renderer.Loader;
import com.aedans.engine.renderer.Renderer;
import com.aedans.platformer.Game;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The Main class for the Game.
 */

public class Main {

    /**
     * The Main function for the Game.
     *
     * @param args: List of arguments for the game.
     */
    public static void main(String[] args){
        try {
            DisplayManager.createDisplay(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false, "F2P Platformer");
            Loader.setOutput(System.out);
            new Game().run();
        } catch (Exception e){
            System.out.print("Could not initialize game: ");
            e.printStackTrace(System.out);
        }
    }

}
