package org.example.p_array;

/*
    Container With Most Water
    https://leetcode.com/problems/container-with-most-water/
 */
public class P10_ContainerWithMostWater {
    public int maxArea(int[] height) {
        var maxArea = Integer.MIN_VALUE;

        var left = 0;
        var right = height.length - 1;

        while (left < right) {
            var containerWidth = right - left;
            var containerHeight = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, containerHeight * containerWidth);

            if (height[left] < height[right])
                ++left;
            else
                --right;
        }

        return maxArea;
    }
}
