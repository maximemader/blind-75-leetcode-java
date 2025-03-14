package org.example.p_tree;

/*
    Binary Tree Maximum Path Sum
    https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class P63_BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        this.maxSum = root.val;

        DFS(root);

        return this.maxSum;
    }

    private int DFS(TreeNode node) {
        if (node == null)
            return 0;

        var left = Math.max(0, DFS(node.left));
        var right = Math.max(0, DFS(node.right));

        this.maxSum = Math.max(this.maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
