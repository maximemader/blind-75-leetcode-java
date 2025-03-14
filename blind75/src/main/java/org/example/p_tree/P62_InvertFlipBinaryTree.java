package org.example.p_tree;

/*
    Invert Binary Tree
    https://leetcode.com/problems/invert-binary-tree/
 */
public class P62_InvertFlipBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var left = invertTree(root.left);
        var right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
