package com.fengyun.math;

import java.util.Arrays;
import java.util.Collections;

import Jama.Matrix;

/**
 * Created by prize on 2017/12/12.
 */

public class RotateMatrix extends Matrix{
    public RotateMatrix(int m, int n) {
        super(m, n);
    }

    public RotateMatrix(int m, int n, double s) {
        super(m, n, s);
    }

    public RotateMatrix(double[][] A) {
        super(A);
    }

    public RotateMatrix(double[][] A, int m, int n) {
        super(A, m, n);
    }

    public RotateMatrix(double[] vals, int m) {
        super(vals, m);
    }

    public RotateMatrix reverse(){
        double[][] arr = getArrayCopy();
        for(int i = 0; i < arr.length; i ++) {
            Collections.reverse(Arrays.asList(arr[i]));
        }
        return new RotateMatrix(arr);
    }

    public RotateMatrix reverseEquals(){
        double[][] arr = getArray();
        for(int i = 0; i < arr.length; i ++) {
            Collections.reverse(Arrays.asList(arr[i]));
        }
        return this;
    }

    public RotateMatrix transposeCustom(){
        Matrix matrix = super.transpose();
        RotateMatrix rotateMatrix = new RotateMatrix(matrix.getArray());
        return rotateMatrix;
    }
    public RotateMatrix rotateAnticlockwise90(){
        return reverse().transposeCustom();
    }

}