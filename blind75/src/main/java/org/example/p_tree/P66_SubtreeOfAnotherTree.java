package org.example.p_tree;

/*
    Subtree Of Another Tree
    https://leetcode.com/problems/subtree-of-another-tree/
 */
public class P66_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return false;

        if (root.val == subRoot.val && compareTrees(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean compareTrees(TreeNode subRootNode, TreeNode subRoot) {
        if (subRootNode == null && subRoot == null)
            return true;

        if (subRootNode == null || subRoot == null)
            return false;

        if (subRootNode.val != subRoot.val)
            return false;

        return compareTrees(subRootNode.left, subRoot.left) && compareTrees(subRootNode.right, subRoot.right);
    }
}
