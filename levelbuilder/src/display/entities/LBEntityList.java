package display.entities;

import display.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class LBEntityList extends JPanel {

    private ArrayList<Entity> entities = new ArrayList<>();

    public LBEntityList(MouseListener mouseListener) {
        mouseListener.addMousePressed(new Function<MouseEvent, Boolean>() {
            @Override
            public Boolean apply(MouseEvent mouseEvent) {
                entities.add(new Entity(mouseEvent.getX(), mouseEvent.getY()));
                return null;
            }
        });
        mouseListener.addMouseReleased(new Function<MouseEvent, Boolean>() {
            @Override
            public Boolean apply(MouseEvent mouseEvent) {
                Entity e = entities.get(entities.size() - 1);
                e.setWidth(mouseEvent.getX()-e.getX());
                e.setHeight(mouseEvent.getY()-e.getY());
                return null;
            }
        });
    }

    @Override
    public void paint(Graphics g){
        for (Entity e : entities){
            e.draw(g);
        }

        repaint();
    }

}
