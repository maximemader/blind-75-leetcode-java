package org.example.p_interval;

import java.util.ArrayList;

/*
    Insert Interval
    https://leetcode.com/problems/insert-interval/
 */
public class P35_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        var index = 0;

        // Insert intervals below the new interval
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);

            ++index;
        }

        // Merge overlapping intervals
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);

            ++index;
        }

        result.add(newInterval);

        // Add remaining intervals after new interval
        while (index < intervals.length) {
            result.add(intervals[index]);

            ++index;
        }

        return result.toArray(new int[result.size()][]);
    }
}
