package org.example.p_array;

/*
    Maximum Product Subarray
    https://leetcode.com/problems/maximum-product-subarray/
 */
public class P06_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // We can adapt P05's Kadane's algorithm to keep track of the maximum product
        // as well as the minimum product. This is because a negative number can flip
        // the maximum product to the minimum product and vice versa.
        var min = nums[0];
        var max = nums[0];
        var result = nums[0];

        for (var i = 1; i < nums.length; ++i) {
            // Negative number flips the min and max
            if (nums[i] < 0) {
                var temp = min;
                min = max;
                max = temp;
            }

            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);

            result = Math.max(result, max);
        }

        return result;
    }
}
