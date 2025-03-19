package org.example.p_matrix;

/*
    Word Search
    https://leetcode.com/problems/word-search/
 */
public class P49_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null || word.isEmpty())
            return false;

        for (var i = 0; i < board.length; ++i) {
            for (var j = 0; j < board[0].length; ++j) {
                // Simple DFS
                if (board[i][j] == word.charAt(0) && Search(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean Search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        var temp = board[i][j];
        board[i][j] = ' ';

        var found = Search(board, word, i + 1, j, index + 1) ||
                Search(board, word, i - 1, j, index + 1) ||
                Search(board, word, i, j + 1, index + 1) ||
                Search(board, word, i, j - 1, index + 1);

        board[i][j] = temp;

        return found;
    }
}
