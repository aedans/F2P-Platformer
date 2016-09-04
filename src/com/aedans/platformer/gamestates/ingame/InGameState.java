package com.aedans.platformer.gamestates.ingame;

import com.aedans.engine.areas.AreaLoader;
import com.aedans.engine.renderer.Renderer;
import com.aedans.engine.renderer.resources.TexturedModel;
import com.aedans.engine.renderer.resources.Textures;
import com.aedans.engine.sprites.Sprite;
import com.aedans.engine.statebasedgame.GameState;
import com.aedans.engine.entities.EntityBox;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Platform;
import com.aedans.platformer.gamestates.ingame.sprites.entities.Player;

import java.io.File;
import java.io.IOException;
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
            Textures.loadTexture("grassFloor.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityBox = new EntityBox(Textures.getNumTextures());
        try {
            AreaLoader.addLoader(s -> {
                Matcher m = Pattern.compile("(\\w+)::([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\d+-.]+),([\\w]+)").matcher(s);
                if (m.find()) {
                    switch (m.group(1)){
                        case "Platform":
                            return new Platform(
                                    Float.parseFloat(m.group(2)),
                                    Float.parseFloat(m.group(3)),
                                    Float.parseFloat(m.group(4)),
                                    Float.parseFloat(m.group(5)),
                                    m.group(6)
                            );
                        default:
                            return new Sprite(
                                    Float.parseFloat(m.group(2)),
                                    Float.parseFloat(m.group(3)),
                                    TexturedModel.getTexturedModel(
                                            Float.parseFloat(m.group(4)),
                                            Float.parseFloat(m.group(5)),
                                            Textures.getTexture(m.group(6))
                                    )
                            ){
                                @Override
                                public void update(long l) {

                                }
                            };
                    }
                } else {
                    return null;
                }
            });
            entityBox.add(AreaLoader.load(new File(".\\assets\\area\\0.area")).getSprites());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
