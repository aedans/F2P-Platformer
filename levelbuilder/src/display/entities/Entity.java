package display.entities;

import java.awt.*;

/**
 * Created by Aedan Smith on 8/31/2016.
 */

public class Entity {

    private int x, y;
    private int width, height;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Entity(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        if (width != 0 && height != 0){
            g.setColor(new Color(0, 0, 0));
            g.fillRect(x, y, width, height);
        }
    }

    public void setWidth(int width) {
        if (width < 0){
            this.width = -width;
            this.x = x+width;
        } else
            this.width = width;
    }

    public void setHeight(int height) {
        if (height < 0){
            this.height = -height;
            this.y = y+height;
        } else
            this.height = height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Entity(" + x + ", " + y + ", " + width + ", " + height + ")";
    }

}
