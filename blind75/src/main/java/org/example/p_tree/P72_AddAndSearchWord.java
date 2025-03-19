package org.example.p_tree;

/*
    Design Add And Search Words Data Structure
    https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class P72_AddAndSearchWord {
    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;

        var current = this.root;

        for (var character : word.toCharArray()) {
            var index = character - 'a';

            if (current.Children[index] == null)
                current.Children[index] = new TrieNode();

            current = current.Children[index];
        }

        current.IsEndOfWord = true;
    }

    public boolean search(String word) {
        return recursiveSearch(root, word, 0);
    }

    private final TrieNode root = new TrieNode();

    private boolean recursiveSearch(TrieNode node, String word, int index) {
        if (index == word.length())
            return node.IsEndOfWord;

        var character = word.charAt(index);

        if (character == '.') {
            for (var i = 0; i < 26; i++) {
                if (node.Children[i] != null && recursiveSearch(node.Children[i], word, index + 1))
                    return true;
            }
        } else {
            var i = character - 'a';

            return node.Children[i] != null && recursiveSearch(node.Children[i], word, index + 1);
        }

        return false;
    }

    class TrieNode {
        public final TrieNode[] Children = new TrieNode[26];
        public boolean IsEndOfWord;
    }
}
