package org.example.p_tree;

import java.util.ArrayList;
import java.util.List;

/*
    Word Search II
    https://leetcode.com/problems/word-search-ii/
 */
public class P73_WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        var trie = new Trie();

        for (var word : words)
            trie.addWord(word);

        var result = new ArrayList<String>();

        for (var i = 0; i < board.length; ++i)
            for (var j = 0; j < board[0].length; ++j)
                DFS(board, i, j, trie.Root, result);

        return result;
    }

    private void DFS(char[][] board, int i, int j, TrieNode node, List<String> result) {
        var character = board[i][j];
        var characterIndex = character - 'a';

        if (character == '#' || node.Children[characterIndex] == null)
            return;

        if (node.Children[characterIndex].Word != null) {
            result.add(node.Children[characterIndex].Word);
            node.Children[characterIndex].Word = null;
        }

        node = node.Children[characterIndex];

        board[i][j] = '#';

        if (i > 0)
            DFS(board, i - 1, j, node, result);

        if (j > 0)
            DFS(board, i, j - 1, node, result);

        if (i < board.length - 1)
            DFS(board, i + 1, j, node, result);

        if (j < board[0].length - 1)
            DFS(board, i, j + 1, node, result);

        board[i][j] = character;
    }

    class Trie {
        public final TrieNode Root = new TrieNode();

        public void addWord(String word) {
            if (word == null || word.isEmpty())
                return;

            var current = Root;

            for (var character : word.toCharArray()) {
                var index = character - 'a';

                if (current.Children[index] == null)
                    current.Children[index] = new TrieNode();

                current = current.Children[index];
            }

            current.Word = word;
        }
    }

    class TrieNode {
        public final TrieNode[] Children = new TrieNode[26];
        public String Word;
    }
}
