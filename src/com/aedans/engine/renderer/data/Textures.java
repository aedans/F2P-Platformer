package com.aedans.engine.renderer.data;

import com.aedans.engine.renderer.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Class for accessing the Textures that the Game is using.
 */

public class Textures {

    private static List<String> textureNames = new ArrayList<>();

    /**
     * Returns the id of a texture with the given name.
     *
     * @param textureName: The name of the texture.
     * @return The texture id.
     */
    public static int getTexture(String textureName){
        if (textureName.contains(textureName)) {
            return textureNames.indexOf(textureName)+1;
        } else {
            return -1;
        }
    }

    /**
     * Returns the id of the texture with the given file name.
     *
     * @param fileName: The name of the texture's file.
     * @return The texture id.
     */
    public static int loadTexture(String fileName) throws Exception {
        if (fileName.endsWith(".png")){
            fileName = fileName.substring(0, fileName.length()-4);
            if (!textureNames.contains(fileName)) {
                Loader.loadPNGTexture(fileName);
                textureNames.add(fileName);
            } else {
                throw new Exception("Texture " + fileName + " is already loaded.");
            }
            return textureNames.size();
        }
        if (fileName.endsWith(".jpg")){
            fileName = fileName.substring(0, fileName.length()-4);
            if (!textureNames.contains(fileName)) {
                Loader.loadJPGTexture(fileName);
                textureNames.add(fileName);
            } else {
                throw new Exception("Texture " + fileName + " is already loaded.");
            }
            return textureNames.size();
        }
        throw new Exception("Could not load texture \"" + fileName + "\"");
    }

}
