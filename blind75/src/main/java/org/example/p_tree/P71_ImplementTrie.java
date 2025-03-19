package org.example.p_tree;

import java.util.HashMap;

/*
    Implement Trie (Prefix Tree)
    https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class P71_ImplementTrie {
    private final HashMap<Character, TrieNode> root = new HashMap<Character, TrieNode>();

    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;

        var letters = word.toCharArray();

        TrieNode current = null;

        for (var character : letters) {
            if (current == null) {
                current = this.root.get(character);

                if (current != null) {
                    continue;
                }

                current = new TrieNode();

                this.root.put(character, current);
            } else {
                var child = current.Children.get(character);
                if (child != null) {
                    current = child;
                } else {
                    child = new TrieNode();
                    current.Children.put(character, child);
                    current = child;
                }
            }
        }

        current.IsEndOfWord = true;
    }

    public boolean search(String word) {
        return searchLetters(word, true);
    }

    public boolean startsWith(String prefix) {
        return searchLetters(prefix, false);
    }

    private boolean searchLetters(String lettersAsString, boolean checkEndOfWord) {
        var letters = lettersAsString.toCharArray();

        TrieNode current = null;

        for (var character : letters) {
            if (current == null) {
                current = this.root.get(character);
                if (current == null)
                    return false;
            } else {
                var next = current.Children.get(character);
                if (next != null) {
                    current = next;
                } else {
                    return false;
                }
            }
        }

        return !checkEndOfWord || current.IsEndOfWord;
    }

    class TrieNode {
        public final HashMap<Character, TrieNode> Children = new HashMap<>();
        public boolean IsEndOfWord;
    }
}
