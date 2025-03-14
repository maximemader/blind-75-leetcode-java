package org.example.p_array;

import java.util.HashMap;

/*
    Two Sum
    https://leetcode.com/problems/two-sum/
 */
public class P01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var data = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; ++i) {
            var diff = target - nums[i];

            if (data.containsKey(diff))
                return new int[]{data.get(diff), i};

            data.put(nums[i], i);
        }

        return new int[0];
    }
}
