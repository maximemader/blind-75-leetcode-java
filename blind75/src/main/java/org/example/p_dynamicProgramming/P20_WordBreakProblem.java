package org.example.p_dynamicProgramming;

import java.util.List;

/*
    Word Break
    https://leetcode.com/problems/word-break/
 */
public class P20_WordBreakProblem {
    public boolean wordBreak(String s, List<String> wordDict) {
        var dp = new boolean[s.length() + 1];
        dp[0] = true;

        var maxWordLength = wordDict.stream().max((a, b) -> a.length() - b.length()).get();

        for (var i = 1; i <= s.length(); ++i) {
            for (var j = i - 1; j >= Math.max(i - maxWordLength.length() - 1, 0); --j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}
