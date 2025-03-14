package org.example.p_tree;

/*
    Lower Common Ancestor Of BST
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class P70_LowestCommonAncestorOfBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true)
        {
            if (p.val > root.val && q.val > root.val)
            {
                root = root.right;
                continue;
            }

            if (p.val < root.val && q.val < root.val)
            {
                root = root.left;
                continue;
            }

            return root;
        }
    }
}
