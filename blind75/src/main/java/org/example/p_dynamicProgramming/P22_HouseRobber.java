package org.example.p_dynamicProgramming;

/*
    House Robber
    https://leetcode.com/problems/house-robber/
 */
public class P22_HouseRobber {
    public int rob(int[] nums) {
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
