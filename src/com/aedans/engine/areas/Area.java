package com.aedans.engine.areas;

import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * A List of Sprites for the Game to use.
 */

public class Area {

    /**
     * The List of Sprites in the Area.
     */
    private ArrayList<Sprite> sprites = new ArrayList<>();

    /**
     * The default Area constructor.
     *
     * @param sprites The List of Sprites in teh Area.
     */
    public Area(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }

    /**
     * Renders the Area.
     */
    public void render() {
        this.sprites.forEach(Sprite::render);
    }

    public void addSprite(Sprite sprite){
        this.sprites.add(sprite);
    }

    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    public Sprite getSprite(int id){
        return sprites.get(id);
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    @Override
    public String toString() {
        String out = "";
        for (Sprite s : sprites){
            out += s + "\n";
        }
        return out;
    }

}
