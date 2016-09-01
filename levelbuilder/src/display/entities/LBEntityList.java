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

    private ArrayList<Entity> toAdd = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public LBEntityList(MouseListener mouseListener) {

    }

    public int addEntity(Entity e){
        this.toAdd.add(e);
        return toAdd.size() + entities.size() - 1;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    @Override
    public void paint(Graphics g){
        for (Entity e : entities){
            e.draw(g);
        }

        entities.addAll(toAdd);
        toAdd = new ArrayList<>();

        repaint();
    }

}
