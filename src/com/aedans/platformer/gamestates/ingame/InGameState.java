package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.levels.LevelLoader;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;
import com.aedans.platformer.gamestates.ingame.sprites.TestEntity;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * The in-game GameState.
 */

public class InGameState extends GameState {

    private EntityBox entityBox;
    private Player player;

    public InGameState(){
        try {
            Textures.loadTexture("player.png");
            Textures.loadTexture("test1.png");
            Textures.loadTexture("test3.png");
            Textures.loadTexture("grassFloor.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityBox = new EntityBox(Textures.getNumTextures());
        try {
            LevelLoader.addLoader(s -> {
                Matcher m = Pattern.compile("\\(([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\d+-.]+)\\)").matcher(s);
                if (m.find()) {
                    return new TestEntity(
                            Float.parseFloat(m.group(1)),
                            Float.parseFloat(m.group(2)),
                            Float.parseFloat(m.group(3)),
                            Float.parseFloat(m.group(4)),
                            "test1"
                    );
                } else {
                    return null;
                }
            });
            entityBox.add(LevelLoader.load(new File(".\\assets\\levels\\test.level")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(entityBox);
        player = new Player(entityBox);
    }

    @Override
    public void update(long l) {
        entityBox.update(l);
        player.update(l);
    }

    @Override
    public void render() {
        Renderer.beginRender();
        entityBox.render();
        player.render();
        Renderer.endRender();
    }

}
