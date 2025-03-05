package org.example.p_dynamicProgramming;

/*
    Climbing Stairs
    https://leetcode.com/problems/climbing-stairs/
 */
public class P16_ClimbingStairs {
    public int climbStairs(int n) {
        // Without using the Fibonacci sequence.
        var result = new int[n + 1];

        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];
    }
}
