package org.example.p_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Pacific Atlantic Water Flow
    https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class P29_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var height = heights.length;
        var width = heights[0].length;

        var result = new ArrayList<List<Integer>>();

        var canFlowToPacific = new boolean[height][width];
        var canFlowToAtlantic = new boolean[height][width];

        // We can start from the borders and check if we can reach the ocean
        // (see https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg)

        // DFS from the borders
        for (var i = 0; i < height; ++i) {
            DFS(heights, canFlowToPacific, i, 0);
            DFS(heights, canFlowToAtlantic, i, width - 1);
        }

        // DFS from the borders
        for (var j = 0; j < width; ++j) {
            DFS(heights, canFlowToPacific, 0, j);
            DFS(heights, canFlowToAtlantic, height - 1, j);
        }

        for (var i = 0; i < height; ++i)
            for (var j = 0; j < width; ++j)
                if (canFlowToPacific[i][j] && canFlowToAtlantic[i][j])

                    result.add(Arrays.asList(i, j));

        return result;
    }

    private static void DFS(int[][] heights, boolean[][] canFlow, int row, int col) {
        if (canFlow[row][col])
            return;

        canFlow[row][col] = true;

        var directions = Arrays.asList(-1, 0, 1, 0, -1);

        for (var direction = 0; direction < 4; ++direction) {
            var nextRow = row + directions.get(direction);
            var nextCol = col + directions.get(direction + 1);

            if (nextRow >= 0 && nextRow < heights.length &&
                    nextCol >= 0 && nextCol < heights[0].length &&
                    heights[nextRow][nextCol] >= heights[row][col])
                DFS(heights, canFlow, nextRow, nextCol);
        }
    }
}
