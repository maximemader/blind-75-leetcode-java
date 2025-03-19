package org.example.p_tree;

import java.util.HashMap;
import java.util.Map;

/*
    Construct Binary Tree From Preorder And Inorder Traversal
    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class P67_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var nodes = new HashMap<Integer, Integer>();

        for (var i = 0; i < inorder.length; ++i)
            nodes.put(inorder[i], i);

        return splitTree(preorder, nodes, 0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> nodes, int preorderIndex, int inOrderLeft, int inOrderRight) {
        var value = preorder[preorderIndex];
        var middleIndex = nodes.get(value);

        var root = new TreeNode(value);

        if (middleIndex > inOrderLeft)
            root.left = splitTree(preorder, nodes, preorderIndex + 1, inOrderLeft, middleIndex - 1);

        if (middleIndex < inOrderRight)
            root.right = splitTree(preorder, nodes, preorderIndex + middleIndex - inOrderLeft + 1, middleIndex + 1, inOrderRight);

        return root;
    }
}
