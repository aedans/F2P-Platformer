package com.aedans.engine.math;

import com.aedans.engine.renderer.DisplayManager;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/23/2016.
 *
 * Utility class for creating matrices.
 */

public class MatrixMath {

    private static float wAspect = (float)DisplayManager.yRes/(float)DisplayManager.xRes;

    /**
     * Creates a Transformation Matrix for an image at (0, 0).
     *
     * @param point: The point to translate the image to.
     * @return The matrix that translates an image at (0, 0) to the correct position.
     */
    public static Matrix4f createTransformationMatrix(Point2D.Float point){
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        Matrix4f.scale(new Vector3f(
                wAspect,
                1,
                1
        ), matrix4f, matrix4f);
        Matrix4f.translate(new Vector2f(point.x, point.y), matrix4f, matrix4f);
        return matrix4f;
    }

    /**
     * Creates a Transformation Matrix for an image at (0, 0).
     *
     * @param x: The X amount to translate the image.
     * @param y: The Y amount to translate the image.
     * @return The matrix that translates an image at (0, 0) to the correct position.
     */
    public static Matrix4f createTransformationMatrix(float x, float y) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        Matrix4f.translate(new Vector2f(x, y), matrix4f, matrix4f);
        return matrix4f;
    }

}
