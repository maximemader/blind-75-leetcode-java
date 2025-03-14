package org.example.p_binary;

/*
    Reverse Bits
    https://leetcode.com/problems/reverse-bits/
 */
public class P15_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        var result = 0;

        for (var i = 0; i < 32; ++i) {
            // Shift the result to the left and add the rightmost bit of n
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }

        return result;
    }
}
