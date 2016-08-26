package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.entities.Entity;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.platformer.gamestates.ingame.sprites.EntityBox;
import com.aedans.platformer.gamestates.ingame.sprites.TestEntity;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;
import com.sun.prism.Texture;

import java.util.function.Function;

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
        entityBox.add(new TestEntity(-.5f, -.7f, .2f, .3f, "test1"));
        entityBox.add(new TestEntity(0, .2f, .2f, .5f, "test1"));
//        entityBox.add(new TestEntity(-1f, 0, .1f, 1, "test3"));
//        entityBox.add(new TestEntity(0, -1f, 1f, .2f, "grassFloor"));
        player = new Player(entityBox);
    }

    @Override
    public void update() {
        entityBox.update();
        player.update();
    }

    @Override
    public void render() {
        Renderer.beginRender();
        entityBox.render();
        player.render();
        Renderer.endRender();
    }

}
