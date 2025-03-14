package org.example.p_tree;

/*
    Maximum Depth of Binary Tree
    https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class P60_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
