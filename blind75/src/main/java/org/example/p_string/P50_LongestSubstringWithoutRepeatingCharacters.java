package org.example.p_string;

import java.util.HashSet;

/*
    Longest Substring Without Repeating Characters
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class P50_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        var chars = new HashSet<Character>();

        var left = 0;
        var right = 0;
        var maxLength = 0;

        while (right < s.length()) {
            if (!chars.add(s.charAt(right))) {
                chars.remove(s.charAt(left));
                ++left;
            } else {
                ++right;
                maxLength = Math.max(maxLength, right - left);
            }
        }

        return maxLength;
    }
}
