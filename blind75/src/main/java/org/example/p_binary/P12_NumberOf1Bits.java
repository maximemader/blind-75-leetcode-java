package org.example.p_binary;

/*
    Number Of 1 Bits
    https://leetcode.com/problems/number-of-1-bits/
 */
public class P12_NumberOf1Bits {
    public int hammingWeight(int n) {
        var count = 0;

        // Brian Kernighan's algorithm
        // Subtracting 1 from a decimal number flips all the bits after the rightmost set bit
        // (including the rightmost set bit).
        while (n != 0) {
            n &= n - 1;
            ++count;
        }

        return count;
    }
}
