package org.example.p_binary;

/*
    Missing Number
    https://leetcode.com/problems/missing-number/
 */
public class P14_MissingNumber {
    public int missingNumber(int[] nums) {
        // Gauss' formula for the sum of the first n numbers.
        var sum = nums.length * (nums.length + 1) / 2;

        // Subtract all the numbers in the array from the sum.
        for (var i = 0; i < nums.length; ++i)
            sum -= nums[i];

        // The missing number is the remaining sum.
        return sum;
    }
}
