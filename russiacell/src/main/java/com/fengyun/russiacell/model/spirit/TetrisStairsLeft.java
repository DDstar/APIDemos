package com.fengyun.russiacell.model.spirit;

import android.content.Context;

import com.fengyun.math.QuadBitMatrix;

import java.util.Random;

/**
 * Created by fengyun on 2017/12/12.
 */

public class TetrisStairsLeft extends Tetris{

    public static final double[][] FLAT_TOP_ARRAY = new double[][]{
            {1, 1, 0},
            {0, 1, 1},
            {0, 0, 0}
    };

    public static final double[][] FLAT_CENTER_ARRAY = new double[][]{
            {0, 0, 0},
            {1, 1, 0},
            {0, 1, 1}
    };

    public static final double[][] SHARP_LEFT_ARRAY = new double[][]{
            {0, 1, 0},
            {1, 1, 0},
            {1, 0, 0}
    };

    public static final double[][] SHARP_CENTER_ARRAY = new double[][]{
            {0, 0, 1},
            {0, 1, 1},
            {0, 1, 0}
    };



    public static final int FLAT_TOP = 1;
    public static final int FLAT_CENTER = 2;
    public static final int SHARP_LEFT = 3;
    public static final int SHARP_CENTER = 4;


    public TetrisStairsLeft(int cx, int cy, Context context, Palette palette,
                            int bitmap, int color, int shape) {
        super(cx, cy, context, palette, bitmap, color);
        QuadBitMatrix matrix = new QuadBitMatrix(getShapeMatrixArray(shape));
        setMatrix(matrix);
    }

    @Override
    public double[][] getShapeMatrixArray(int shape) {
        switch (shape){
            case FLAT_TOP:
                return FLAT_TOP_ARRAY;
            case FLAT_CENTER:
                return FLAT_CENTER_ARRAY;
            case SHARP_LEFT:
                return SHARP_LEFT_ARRAY;
            case SHARP_CENTER:
                return SHARP_CENTER_ARRAY;
            case SHAPE_RANDOM:
            default:
                return getShapeMatrixArray(new Random().nextInt(3));
        }
    }

}
