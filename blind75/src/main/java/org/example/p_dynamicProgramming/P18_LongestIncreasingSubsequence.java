package org.example.p_dynamicProgramming;

import java.util.Arrays;

/*
    Longest Increasing Subsequence
    https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class P18_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // We can reuse the same array to store the longest increasing subsequence
        // since the current index is always greater than the subsequence.
        //var dp = new int[nums.Length];
        var length = 0;

        for (var num : nums) {
            var i = Arrays.binarySearch(nums, 0, length, num);

            if (i < 0)
                i = ~i;

            nums[i] = num;

            if (i == length)
                ++length;
        }

        return length;
    }
}
