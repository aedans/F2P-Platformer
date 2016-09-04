package com.aedans.engine.levels;

import com.aedans.engine.sprites.Sprite;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Class for loading levels from .level files.
 */

public class LevelLoader {

    private static ArrayList<Function<String, Sprite>> loaders = new ArrayList<>();

    public static Level load(File file) throws IOException {
        ArrayList<Sprite> sprites = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            for (Function<String, Sprite> l : loaders){
                Sprite loaded = l.apply(line);
                if (loaded != null){
                    sprites.add(loaded);
                }
            }
        }
        buffer.close();
        return new Level(sprites);
    }

    public static void addLoader(Function<String, Sprite> loader){
        loaders.add(loader);
    }

}
