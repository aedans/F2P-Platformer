package com.aedans.engine.levels;

import com.aedans.engine.entities.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 9/3/2016.
 *
 * Class for loading levels from .level files.
 */

public class LevelLoader {

    private static ArrayList<Function<String, Entity>> loaders = new ArrayList<>();

    public static ArrayList<Entity> load(File file) throws IOException {
        ArrayList<Entity> entities = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            for (Function<String, Entity> l : loaders){
                Entity loaded = l.apply(line);
                if (loaded != null){
                    entities.add(loaded);
                }
            }
        }
        buffer.close();
        return entities;
    }

    public static void addLoader(Function<String, Entity> loader){
        loaders.add(loader);
    }

}
