package org.example.p_string;

/*
    Palindromic Substrings
    https://leetcode.com/problems/palindromic-substrings/
 */
public class P58_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (null == s || s.isEmpty())
            return 0;

        var palindromes = new boolean[s.length()][];
        for (var i = 0; i < palindromes.length; ++i)
            palindromes[i] = new boolean[s.length()];

        var count = s.length();

        // We can fill single characters
        for (var i = 0; i < s.length(); ++i)
            palindromes[i][i] = true;

        // We can fill pairs of characters
        for (var i = 0; i < s.length() - 1; ++i)
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromes[i][i + 1] = true;
                ++count;
            }

        // We can fill the rest
        for (var l = 3; l <= s.length(); ++l) {
            for (var i = 0; i < s.length() - l + 1; ++i) {
                // If the first and last characters are the same and the inner substring is a palindrome
                // then the whole substring is a palindrome.
                if (s.charAt(i) == s.charAt(i + l - 1) && palindromes[i + 1][i + l - 2]) {
                    palindromes[i][i + l - 1] = true;
                    ++count;
                }
            }
        }

        return count;
    }
}
