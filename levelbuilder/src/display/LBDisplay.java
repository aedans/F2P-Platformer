package display;

import display.entities.LBEntityList;
import display.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class LBDisplay extends JFrame {

    private MouseListener mouseListener = new MouseListener();

    private LBEntityList lbEntityList = new LBEntityList(mouseListener);

    public LBDisplay(int xRes, int yRes){
        this.setTitle("Level Builder");
        this.setUndecorated(true);
        this.add(lbEntityList);
        this.addMouseListener(mouseListener);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(xRes, yRes);
        this.setVisible(true);
        this.requestFocus();
    }

    public LBEntityList getLbEntityList() {
        return lbEntityList;
    }

    public MouseListener getMouseListener() {
        return mouseListener;
    }

}
