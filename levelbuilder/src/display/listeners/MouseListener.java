package display.listeners;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class MouseListener implements java.awt.event.MouseListener {

    private ArrayList<Function<MouseEvent, Boolean>> onMouseClicked = new ArrayList<>();
    private ArrayList<Function<MouseEvent, Boolean>> onMousePressed = new ArrayList<>();
    private ArrayList<Function<MouseEvent, Boolean>> onMouseReleased = new ArrayList<>();

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Function<MouseEvent, Boolean> f : onMouseClicked){
            f.apply(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(Function<MouseEvent, Boolean> f : onMousePressed){
            f.apply(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Function<MouseEvent, Boolean> f : onMouseReleased){
            f.apply(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addMouseClicked(Function<MouseEvent, Boolean> function){
        this.onMouseClicked.add(function);
    }

    public void addMousePressed(Function<MouseEvent, Boolean> function){
        this.onMousePressed.add(function);
    }

    public void addMouseReleased(Function<MouseEvent, Boolean> function){
        this.onMouseReleased.add(function);
    }

}
