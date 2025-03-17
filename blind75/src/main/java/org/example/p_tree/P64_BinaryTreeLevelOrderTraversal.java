package org.example.p_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
    Binary Tree Level Order Traversal
    https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class P64_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        var queue = new ArrayDeque<NodeLevel>();

        queue.push(new NodeLevel(root, 0));

        while (!queue.isEmpty()) {
            var current = queue.pollLast();
            if (result.size() == current.level())
                result.add(new ArrayList<>());

            result.get(current.level()).add(current.node().val);

            if (current.node().left != null)
                queue.push(new NodeLevel(current.node().left, current.level() + 1));

            if (current.node().right != null)
                queue.push(new NodeLevel(current.node().right, current.level() + 1));
        }

        return result;
    }

    record NodeLevel(TreeNode node, int level) {
    }
}
