package org.example.p_matrix;

import java.util.ArrayList;
import java.util.List;

/*
    Spiral Matrix
    https://leetcode.com/problems/spiral-matrix/
 */
public class P47_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();

        var result = new ArrayList<Integer>();

        var top = 0;
        var bottom = matrix.length - 1;
        var left = 0;
        var right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; ++i)
                result.add(matrix[top][i]);

            if (++top > bottom)
                break;

            for (int i = top; i <= bottom; ++i)
                result.add(matrix[i][right]);

            if (left > --right)
                break;

            for (int i = right; i >= left; --i)
                result.add(matrix[bottom][i]);

            if (top > --bottom)
                break;

            for (int i = bottom; i >= top; --i)
                result.add(matrix[i][left]);

            if (++left > right)
                break;
        }

        return result;
    }
}
