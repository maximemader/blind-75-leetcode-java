package org.example.p_dynamicProgramming;

import java.util.Arrays;

/*
    Combination Sum
    https://leetcode.com/problems/combination-sum-iv/
 */
public class P21_CombinationSum {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 0;

        if (nums.length == 0)
            return -1;

        Arrays.sort(nums);

        var dp = new int[target + 1];
        dp[0] = 1;

        for (var i = 1; i <= target; ++i) {
            for (var num : nums) {
                if (i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}
