package org.example.p_graph;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
    Longest Consecutive Sequence
    https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class P31_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // We could avoid this by using hashmaps and do some merging.
        // This solution is easier to understand.
        var values = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        var longest = 0;

        for (int num : nums) {
            var lower = num - 1;
            var higher = num + 1;

            while (values.remove(lower))
                --lower;
            while (values.remove(higher))
                ++higher;

            longest = Math.max(longest, higher - lower - 1);

            if (values.isEmpty())
                break;
        }

        return longest;
    }
}
