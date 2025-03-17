package org.example.p_graph;

import java.util.HashMap;

/*
    Clone Graph
    https://leetcode.com/problems/clone-graph/
 */
public class P27_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        var copies = new HashMap<Node, Node>();

        return CloneGraph(node, copies);
    }

    private static Node CloneGraph(Node node, HashMap<Node, Node> copies) {
        Node cloneGraph = null;
        if ((cloneGraph = copies.getOrDefault(node, cloneGraph)) != null)
            return cloneGraph;

        var copy = new Node(node.val);
        copies.put(node, copy);

        for (var neighbor : node.neighbors) {
            copy.neighbors.add(CloneGraph(neighbor, copies));
        }

        return copy;
    }
}
