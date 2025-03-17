package org.example.p_dynamicProgramming;

/*
    Decode Ways
    https://leetcode.com/problems/decode-ways/
 */
public class P24_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        if (s.charAt(0) == '0')
            return 0;

        var dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (var i = 2; i <= s.length(); ++i) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];

            var n = Integer.parseInt(s.substring((i - 2), i));

            if (n >= 10 && n <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }
}
