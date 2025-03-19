package org.example.p_matrix;

import java.util.Arrays;

/*
    Set Matrix Zeroes
    https://leetcode.com/problems/set-matrix-zeroes/
 */
public class P46_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        var markerRow = false;
        var markerColumn = false;

        // We're using the first column and the first row to mark the zeroes.
        // We keep track if we have to clear them later.
        for (var i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                markerColumn = true;
                break;
            }
        }

        for (var j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                markerRow = true;
                break;
            }
        }

        for (var i = 1; i < matrix.length; ++i) {
            for (var j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (var i = 1; i < matrix.length; ++i)
            for (var j = 1; j < matrix[0].length; ++j)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        // Clear the first row and the first column if we marked them.
        if (markerRow)
            Arrays.fill(matrix[0], 0);

        if (markerColumn)
            for (var i = 0; i < matrix.length; ++i)
                matrix[i][0] = 0;
    }
}
