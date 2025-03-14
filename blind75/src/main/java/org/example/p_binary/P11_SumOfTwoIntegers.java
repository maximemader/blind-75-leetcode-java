package org.example.p_binary;

/*
    Sum Of Two Integers
    https://leetcode.com/problems/sum-of-two-integers/
 */
public class P11_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Compute the carry by performing AND operation on a and b
            // and then shifting it left by 1.
            var carry = (a & b) << 1;

            // Compute the sum by performing XOR operation on a and b.
            // XOR operation does the addition without considering the carry.
            a ^= b;

            // The carry is set to b to compute the sum.
            b = carry;
        }
        return a;
    }
}
