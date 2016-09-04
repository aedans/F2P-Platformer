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

    /**
     * List of Functions to assist the Area loading.
     */
    private static ArrayList<Function<String, Sprite>> loaders = new ArrayList<>();

    /**
     * Loads an Area from a .area File.
     *
     * @param file The .area File to load from.
     * @return The Area.
     * @throws IOException if there is an error loading the Area.
     */
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
