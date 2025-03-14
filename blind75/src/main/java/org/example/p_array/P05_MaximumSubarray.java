package org.example.p_array;

/*
    Maximum Subarray
    https://leetcode.com/problems/maximum-subarray/
 */
public class P05_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm
        var largestSum = Integer.MIN_VALUE;
        var currentSum = 0;

        for (var num : nums) {
            currentSum = Math.max(num, num + currentSum);
            largestSum = Math.max(largestSum, currentSum);
        }

        return largestSum;
    }
}
