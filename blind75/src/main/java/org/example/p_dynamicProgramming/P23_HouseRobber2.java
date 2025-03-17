package org.example.p_dynamicProgramming;

import java.util.Arrays;

/*
    House Robber 2
    https://leetcode.com/problems/house-robber-ii/
 */
public class P23_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        return Math.max(
                robV1(Arrays.stream(nums).skip(1).toArray()),
                robV1(Arrays.stream(nums).limit(nums.length - 1).toArray()));
    }

    private int robV1(int[] nums) {
        if (nums.length == 0)
            return 0;

        // We can simplify even further by using two variables to store the previous
        // and previous previous values (i.e. Fibonacci).
        var prev = 0;
        var prevPrev = 0;

        for (var num : nums) {
            var temp = prev;
            prev = Math.max(prev, prevPrev + num);
            prevPrev = temp;
        }

        return prev;
    }
}
