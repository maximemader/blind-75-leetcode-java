package org.example.p_tree;

import java.util.Stack;

/*
    Kth Smallest Element In A BST
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class P69_KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        var stack = new Stack<TreeNode>();

        var current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse left up to the leftmost node
            while (current != null) {
                stack.push(current);

                current = current.left;
            }

            current = stack.pop();

            if (--k == 0)
                return current.val;

            current = current.right;
        }

        return root.val;
    }
}
