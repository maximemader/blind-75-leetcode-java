package org.example.p_dynamicProgramming;

/*
    Jump Game
    https://leetcode.com/problems/jump-game/
 */
public class P26_JumpGame {
    public boolean canJump(int[] nums) {
        var max = 0;

        for (var i = 0; i < nums.length; ++i) {
            if (i > max)
                return false;

            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}
