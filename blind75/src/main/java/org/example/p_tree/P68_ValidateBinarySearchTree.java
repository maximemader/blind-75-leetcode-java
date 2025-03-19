package org.example.p_tree;

import java.util.Stack;

/*
    Validate Binary Search Tree
    https://leetcode.com/problems/validate-binary-search-tree/
 */
public class P68_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        var stack = new Stack<TreeNode>();

        Integer leftValue = null;

        var current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse left up to the leftmost node
            while (current != null) {
                stack.push(current);

                current = current.left;
            }

            current = stack.pop();

            // If the current node's value is less than or equal to the previous node's value,
            // return false
            if (leftValue != null && leftValue >= current.val)
                return false;

            leftValue = current.val;
            current = current.right;
        }

        return true;
    }
}
