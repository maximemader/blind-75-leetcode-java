package org.example.p_tree;

/*
    Same Tree
    https://leetcode.com/problems/same-tree/
 */
public class P61_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;

        if (p == null || q == null)
            return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
