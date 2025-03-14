package org.example.p_array;

import java.util.HashSet;

/*
    Contains Duplicate
    https://leetcode.com/problems/contains-duplicate/
 */
public class P03_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        var data = new HashSet<Integer>();

        for (int num : nums)
            if (!data.add(num))
                return true;

        return false;
    }
}
