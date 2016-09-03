package display.entities;

import display.listeners.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class LBEntityList extends JPanel {

    private ArrayList<Entity> toAdd = new ArrayList<>();
    private ArrayList<Entity> toRemove = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();

    public LBEntityList(MouseListener mouseListener) {

    }

    public void pushEntities(){
        entities.addAll(toAdd);
        toAdd = new ArrayList<>();

        for (Entity e : toRemove) {
            entities.remove(e);
        }
        toRemove = new ArrayList<>();
    }


    @Override
    public void paint(Graphics g) {
        pushEntities();

        for (Entity e : entities) {
            e.draw(g);
        }

        repaint();
    }

    @Override
    public String toString() {
        pushEntities();
        String s = "";
        ArrayList<Entity> es = (ArrayList<Entity>) entities.clone();
        for (Entity e : es) {
            s += e.toString() + "\n";
        }
        return s;
    }

    public int addEntity(Entity e) {
        this.toAdd.add(e);
        return toAdd.size() - toRemove.size() + entities.size() - 1;
    }

    public void removeEntity(Entity e) {
        this.toRemove.add(e);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

}
