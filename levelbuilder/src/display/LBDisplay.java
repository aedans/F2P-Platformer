package display;

import display.entities.LBEntityList;
import display.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class LBDisplay extends JFrame {

    public MouseListener mouseListener = new MouseListener();

    public LBDisplay(int xRes, int yRes){
        this.setTitle("Level Builder");
        this.setUndecorated(true);
        this.add(new LBEntityList(mouseListener));
        this.addMouseListener(mouseListener);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(xRes, yRes);
        this.setVisible(true);
        this.requestFocus();
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

}
