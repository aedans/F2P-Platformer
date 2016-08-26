package com.aedans.engine.entities;

/**
 * Created by Aedan Smith on 8/23/2016.
 *
 * Interface for creating component-based objects.
 */

public interface Component<T> {

    void apply(T t, long l);

}
