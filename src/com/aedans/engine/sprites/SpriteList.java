package com.aedans.engine.sprites;

import com.aedans.engine.renderer.Renderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Aedan Smith on 8/24/2016.
 * <p>
 * A List of Sprites to be used by the Renderer.
 */

public abstract class SpriteList<T extends Sprite> {

    /**
     * The number of possible resources.
     */
    public int numTextures;

    /**sd
     * The list of Sprites to add on the next update(). Prevents Concurrent
     * Modification Exceptions.
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayList<T> toAdd = new ArrayList<>();

    /**
     * The list of Sprites to remove on the next update(). Prevents Concurrent
     * Modification Exceptions.
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayList<T> toRemove = new ArrayList<>();

    /**
     * An Array of Sprites, one ArrayList for each Texture.
     */
    protected ArrayList<T>[] sprites;

    /**
     * Default SpriteList constructor.
     *
     * @param numTextures: The number of resources the SpriteList should support.
     */
    public SpriteList(int numTextures) {
        this.numTextures = numTextures;
        //noinspection unchecked
        this.sprites = new ArrayList[numTextures];
        for (int i = 0; i < numTextures; i++)
            sprites[i] = new ArrayList<>();
    }

    /**
     * Puts a List of Sprites in a queue to be added next update();
     *
     * @param sprites: The List of Renderables to add.
     */
    public void add(List<T> sprites) {
        toAdd.addAll(sprites);
    }

    /**
     * Puts any number of Sprites in a queue to be added next update();
     *
     * @param sprites: The Sprites to add.
     */
    @SafeVarargs
    public final void add(T... sprites) {
        Collections.addAll(toAdd, sprites);
    }

    /**
     * Puts a List of Sprites in a queue to be removed next update();
     *
     * @param sprites: The List of Sprites to remove.
     */
    public void remove(List<T> sprites) {
        toRemove.addAll(sprites);
    }

    /**
     * Puts any number of Sprites in a queue to be removed next update();
     *
     * @param sprites: The Sprites to remove.
     */
    @SafeVarargs
    public final void remove(T... sprites) {
        Collections.addAll(toRemove, sprites);
    }

    /**
     * Applies the function to all Sprites.
     *
     * @param iterator: Function to be applied once for every Sprite. Takes the Sprite as an argument, returns
     *                true if the iterator should stop iterating.
     * @return The Sprite that the iterator stopped iterating on. Null if the iterator iterated through everything.
     */
    public T iterate(Function<T, Boolean> iterator){
        for (ArrayList<T> ts : sprites){
            for (T t : ts){
                if (iterator.apply(t))
                    return t;
            }
        }
        return null;
    }

    /**
     * Function to update all Sprites.
     */
    public void update() {
        // Adds all Sprites in the toAdd queue.
        for (T t : toAdd) {
            sprites[t.getTexturedModel().getTextureID() - 1].add(t);
            onAdd(t);
        }
        toAdd = new ArrayList<>();

        // Removes all Sprites in the toRemove queue.
        for (T t : toRemove) {
            get(t.getTexturedModel().getTextureID() - 1).remove(t);
            onRemove(t);
        }
        toRemove = new ArrayList<>();

        for (ArrayList<T> sprites : this.sprites){
            sprites.forEach(Sprite::update);
        }

        onUpdate();
    }

    /**
     * Function to render all Sprites.
     */
    public void render(){
        onRender();

        // TODO: Optimize
        for (ArrayList<T> sprites : this.sprites){
            if (sprites.size() != 0) {
                for (Sprite s : sprites) {
                    Renderer.loadTexturedModel(s.getTexturedModel());
                    Renderer.compositeShader.loadTransformationMatrix(s.getTransformationMatrix());
                    Renderer.drawElements();
                }
            }
        }
    }

    /**
     * Returns all Sprites with the given Texture ID.
     *
     * @param textureID: The Texture ID of the requested Sprites.
     * @return The ArrayList of Sprites.
     */
    public ArrayList<T> get(int textureID) {
        return sprites[textureID];
    }

    /**
     * Checks is the SpriteList contains a given Sprites.
     *
     * @param r: The Sprites to check.
     * @return true if the SpriteList contains the given Sprites;
     */
    public boolean contains(T r) {
        for (int i = 0; i < numTextures; i++) {
            for (T t : get(i)) {
                if (t == r)
                    return true;
            }
        }
        return false;
    }

    /**
     * Add hook.
     *
     * @param t: The added Sprite.
     */
    protected abstract void onAdd(T t);

    /**
     * Remove hook.
     *
     * @param t: The removed Sprite.
     */
    protected abstract void onRemove(T t);

    /**
     * Update hook.
     */
    protected abstract void onUpdate();

    /**
     * Render hook
     */
    protected abstract void onRender();

}
