package org.example.p_interval;

import java.util.Arrays;
import java.util.Comparator;

/*
    Non-Overlapping Intervals
    https://leetcode.com/problems/non-overlapping-intervals/
 */
public class P37_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        var count = 1;
        var previous = 0;

        for (var i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[previous][1])
                continue;

            previous = i;
            ++count;
        }

        return intervals.length - count;
    }
}
