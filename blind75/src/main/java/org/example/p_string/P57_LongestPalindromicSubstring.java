package org.example.p_string;

/*
    Longest Palindromic Substring
    https://leetcode.com/problems/longest-palindromic-substring/
 */
public class P57_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        var maxLength = 1;
        var maxSubstring = s.substring(0, 1);

        // Manacher's algorithm
        s = "#" + s.replaceAll("", "#") + "#";
        var dp = new int[s.length()];
        var center = 0;
        var right = 0;

        for (var i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length() && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxSubstring = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxSubstring;
    }
}
