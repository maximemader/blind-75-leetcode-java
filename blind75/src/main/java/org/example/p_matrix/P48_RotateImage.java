package org.example.p_matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/*
    Rotate Image
    https://leetcode.com/problems/rotate-image/
 */
public class P48_RotateImage {
    public void rotate(int[][] matrix) {
        // Matrix is a square matrix
        var length = matrix.length;

        // Transpose the matrix
        for (var i = 0; i < length; ++i) {
            for (var j = i + 1; j < length; ++j) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (var i = 0; i < length; ++i) {
            var temp = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
            Collections.reverse(temp);
            matrix[i] = temp.stream().mapToInt(x -> x).toArray();
        }
    }
}
