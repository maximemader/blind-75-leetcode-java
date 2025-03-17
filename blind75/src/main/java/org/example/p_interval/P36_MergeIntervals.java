package org.example.p_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    Merge Intervals
    https://leetcode.com/problems/merge-intervals/
 */
public class P36_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        var result = new ArrayList<int[]>();

        var previous = intervals[0];

        for (var i = 1; i < intervals.length; ++i) {
            var current = intervals[i];

            if (previous[1] >= current[0]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                result.add(previous);
                previous = current;
            }
        }

        result.add(previous);

        return result.toArray(new int[0][]);
    }
}
