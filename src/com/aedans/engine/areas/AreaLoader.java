package com.aedans.engine.areas;

import com.aedans.engine.sprites.Sprite;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Class for loading area from .level files.
 */

public class AreaLoader {

    private static ArrayList<Function<String, Sprite>> loaders = new ArrayList<>();

    public static Area load(File file) throws IOException {
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
        return new Area(sprites);
    }

    public static void addLoader(Function<String, Sprite> loader){
        loaders.add(loader);
    }

}
