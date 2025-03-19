package org.example.p_string;

import java.util.HashMap;

/*
    Minimum Window Substring
    https://leetcode.com/problems/minimum-window-substring/
 */
public class P52_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() ||
                s.length() < t.length()) {
            return "";
        }
        var map = new int[128];
        var count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        for (var c : t.toCharArray()) {
            map[c]++;
        }

        var chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0)
                count--;

            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }

                if (map[chS[start++]]++ == 0)
                    count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(chS, startIndex, minLen);
    }
}
