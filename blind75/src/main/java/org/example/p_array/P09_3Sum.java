package org.example.p_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    3 Sum
    https://leetcode.com/problems/3sum/
 */
public class P09_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        // In order to have a better score, we're not using HashSet nor Tuple to check for
        // duplicates, we're using the array sorted to check for duplicates.
        for (var i = 0; i < nums.length - 2; ++i) {
            var left = i + 1;
            var right = nums.length - 1;

            var target = -1 * nums[i];

            while (left < right) {
                var sum = nums[left] + nums[right];

                if (sum < target)
                    ++left;
                else if (sum > target)
                    --right;
                else {
                    var leftValue = nums[left];
                    var rightValue = nums[right];

                    result.add(Arrays.asList(nums[i], leftValue, rightValue));

                    if (leftValue == rightValue)
                        break;

                    while (left < right && nums[left] == leftValue)
                        ++left;

                    while (left < right && nums[right] == rightValue)
                        --right;
                }
            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                ++i;
        }

        return result;
    }
}
