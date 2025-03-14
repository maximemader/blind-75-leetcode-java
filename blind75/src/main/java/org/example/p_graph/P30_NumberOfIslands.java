package org.example.p_graph;

public class P30_NumberOfIslands {
    public int numIslands(char[][] grid) {
        var result = 0;

        // No TLE nor StackOverflow with DFS
        // if the grid is very large, we can use BFS.
        for (var i = 0; i < grid.length; ++i) {
            for (var j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++result;

                    DFS(grid, i, j);
                }
            }
        }

        return result;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 ||
                j < 0 || j > grid[0].length - 1 ||
                grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}
