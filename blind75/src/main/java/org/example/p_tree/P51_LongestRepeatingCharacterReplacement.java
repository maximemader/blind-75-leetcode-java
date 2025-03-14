package org.example.p_tree;

/*
    Longest Repeating Character Replacement
    https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class P51_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        var freq = new int[26];
        var highestFrequency = 0;
        var left = 0;
        var max = 0;

        for(var right = 0; right < s.length(); ++right) {
            var ci = s.charAt(right) - 'A';
            ++freq[ci];
            highestFrequency = Math.max(highestFrequency, freq[ci]);

            var frequency = (right - left + 1) - highestFrequency;
            if(frequency > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
