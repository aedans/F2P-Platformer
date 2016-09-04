package com.aedans.engine.levels;

import com.aedans.engine.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 9/3/2016.
 */

public class Level {

    private ArrayList<Sprite> sprites = new ArrayList<>();

    public Level(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
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

    public void render() {
        sprites.forEach(Sprite::render);
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
