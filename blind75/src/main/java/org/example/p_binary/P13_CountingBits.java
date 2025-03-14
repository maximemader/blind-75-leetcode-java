package org.example.p_binary;

/*
    Counting Bits
    https://leetcode.com/problems/counting-bits/
 */
public class P13_CountingBits {
    public int[] countBits(int n) {
        var result = new int[n + 1];
        result[0] = 0;

        for (var i = 1; i <= n; ++i)
            result[i] = result[i >> 1] + (i & 1);

        return result;
    }
}
