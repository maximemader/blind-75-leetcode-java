package org.example.p_array;

/*
    Find Minimum In Rotated Sorted Array
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class P07_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length - 1;

        // Simple binary search, the array is rotated but originally sorted
        // with distinct values.
        while (left < right) {
            var mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}
