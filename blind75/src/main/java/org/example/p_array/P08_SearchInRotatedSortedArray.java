package org.example.p_array;

/*
    Search in Rotated Sorted Array
    https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class P08_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        // We're reusing P07 binary search to find the pivot point,
        // then we'll use the pivot point to determine which half of the array
        // to search for the target.
        while (left < right) {
            var mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        var start = left;
        left = 0;
        right = nums.length - 1;

        // Determine which part of the array to search
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;

        // Binary search in the determined part
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
