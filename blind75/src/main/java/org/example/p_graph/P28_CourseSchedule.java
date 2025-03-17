package org.example.p_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
    Course Schedule
    https://leetcode.com/problems/course-schedule/
 */
public class P28_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adj = new ArrayList<List<Integer>>();

        for (var i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());

        for (var prerequisite : prerequisites)
            adj.get(prerequisite[1]).add(prerequisite[0]);

        return TopologicalSort(adj, numCourses).size() == numCourses;

    }

    /*
        Kahn's Algorithm
     */
    static List<Integer> TopologicalSort(List<List<Integer>> adj, int V) {
        // Vector to store indegree of each vertex
        var indegree = new int[V];

        for (var vertex : adj.stream().flatMap(x -> x.stream()).toList())
            ++indegree[vertex];

        // Queue to store vertices with indegree 0
        var q = new ArrayDeque<Integer>();

        for (var i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);

        var result = new ArrayList<Integer>();

        while (!q.isEmpty()) {
            var node = q.poll();
            result.add(node);

            // Decrease indegree of adjacent vertices as the current node is in topological order
            for (var adjacent : adj.get(node).stream().toList()) {
                --indegree[adjacent];

                // If indegree becomes 0, push it to the queue
                if (indegree[adjacent] == 0)
                    q.add(adjacent);
            }
        }

        // Check for cycle
        return result.size() == V ? result : new ArrayList<>();
    }
}
