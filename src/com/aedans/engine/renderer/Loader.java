package com.aedans.engine.renderer;

import com.aedans.engine.renderer.data.Models;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    /**
     * The PrintStream for the Loader to output to.
     */
    private static PrintStream output = null;

    /**
     * The directory of the images.
     */
    private static String RES_DIR = "assets/imgs/";

    /**
     * List of Vertex Attribute Objects.
     */
    private static List<Integer> vaos = new ArrayList<>();

    /**
     * List of Vertex Buffer Objects.
     */
    private static List<Integer> vbos = new ArrayList<>();

    /**
     * List of loaded Textures.
     */
    private static List<Integer> textures = new ArrayList<>();

    /**
     * Loads a Model to the VAO.
     *
     * @param vertices: The vertices of the vertices.
     * @param indices:   The indices of the Model.
     * @return int: The location at which the Model is stored in OpenGL.
     */
    @SuppressWarnings("WeakerAccess")
    public static int loadToVAO(float[] vertices, int[] indices) {
        int i = Models.contains(vertices, indices);
        if (i == -1) {
            float[] textures = new float[]{
                    0, 0, 0, 1, 1, 1, 1, 0
            };
            int vaoID = createVAO();
            bindIndicesBuffer(indices);
            storeDataInAttributeList(0, 3, vertices);
            storeDataInAttributeList(1, 2, textures);
            unbindVAO();
            Models.add(vertices, indices);
            printf("Loaded Model (%d vertices, %d indices) to ModelID %d", vertices.length, indices.length, Models.size);
            return vaoID;
        } else {
            // OpenGL's VAO and VBO IDs are not 0-based.
            return i + 1;
        }
    }

    /**
     * Creates a VAO.
     *
     * @return int: The VAO ID.
     */
    private static int createVAO() {
        int vaoID = GL30.glGenVertexArrays();
        vaos.add(vaoID);
        GL30.glBindVertexArray(vaoID);
        return vaoID;
    }

    /**
     * Binds an int[] to the bound VAO.
     *
     * @param indices: The indicies to store.
     */
    private static void bindIndicesBuffer(int[] indices) {
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
        IntBuffer buffer = storeDataInIntBuffer(indices);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
    }

    /**
     * Loads a PNG Texture.
     *
     * @param fileName: The name of the image to load.
     * @return int: The location at which the image is stored in OpenGL.
     */
    public static int loadPNGTexture(String fileName) {
        try {
            Texture texture = TextureLoader.getTexture("PNG", new FileInputStream(RES_DIR + fileName + ".png"));
            int textureID = texture.getTextureID();
            textures.add(textureID);
            printf("Loaded Texture \"%s.png\" to TextureID %d", fileName, textureID);
            return textureID;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Loads a JPEG Texture.
     *
     * @param fileName: The name of the image to load.
     * @return int: The location at which the image is stored in OpenGL.
     */
    public static int loadJPGTexture(String fileName) {
        try {
            Texture texture = TextureLoader.getTexture("JPG", new FileInputStream(RES_DIR + fileName + ".jpg"));
            int textureID = texture.getTextureID();
            textures.add(textureID);
            printf("Loaded Texture \"%s.jpg\" to TextureID %d", fileName, textureID);
            return textureID;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Cleans up the VAOs, VBOs, and Textures used by OpenGL.
     */
    public static void cleanUp() {
        vaos.forEach(GL30::glDeleteVertexArrays);
        printf("Cleaned up VAOs.");
        vbos.forEach(GL15::glDeleteBuffers);
        printf("Cleaned up VBOs.");
        textures.forEach(GL11::glDeleteTextures);
        printf("Cleaned up Textures.");
    }

    /**
     * Stores data in a VBO.
     *
     * @param attributeNumber: The VBO to store the data in.
     * @param infosize:        The number of indexes used to store a piece of data.
     * @param data:            The data to store.
     */
    private static void storeDataInAttributeList(int attributeNumber, int infosize, float[] data) {
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        FloatBuffer buffer = storeDataInFloatBuffer(data);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, infosize, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    /**
     * Unbinds a VAO.
     */
    private static void unbindVAO() {
        GL30.glBindVertexArray(0);
    }

    /**
     * Creates an IntBuffer with the given data.
     *
     * @param data: The data to store in the IntBuffer.
     * @return IntBuffer: The created IntBuffer.
     */
    private static IntBuffer storeDataInIntBuffer(int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    /**
     * Creates an FloatBuffer with the given data.
     *
     * @param data: The data to store in the FloatBuffer.
     * @return FloatBuffer: The created FloatBuffer.
     */
    private static FloatBuffer storeDataInFloatBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    /**
     * Sets the Loader output to a given PrintStream.
     *
     * @param printStream: The PrintStream to print to.
     */
    public static void setOutput(PrintStream printStream){
        output = printStream;
    }

    private static void printf(String s, Object... args){
        if (output != null) {
            output.printf(s + "\n", args);
        }
    }

}
