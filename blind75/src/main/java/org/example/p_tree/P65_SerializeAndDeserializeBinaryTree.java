package org.example.p_tree;

/*
    Serialize and Deserialize Binary Tree
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class P65_SerializeAndDeserializeBinaryTree {
    private static final String SEPARATOR = ",";
    private static final String NULL_MARKER = "null";
    private int index = 0;

    public String serialize(TreeNode root) {
        var sb = new StringBuilder();

        buildString(root, sb);

        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append(NULL_MARKER).append(SEPARATOR);
        else {
            sb.append(root.val).append(SEPARATOR);

            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        index = 0;

        String[] arr = data.split(SEPARATOR);

        return buildTree(arr);
    }

    public TreeNode buildTree(String[] array) {
        var p = array[index++];

        if (p.equals(NULL_MARKER))
            return null;

        var root = new TreeNode(Integer.parseInt(p));

        root.left = buildTree(array);
        root.right = buildTree(array);

        return root;
    }
}
