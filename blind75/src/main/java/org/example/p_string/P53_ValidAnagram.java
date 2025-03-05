package org.example.p_string;

import java.util.Arrays;

/*
    Valid Anagram
    https://leetcode.com/problems/valid-anagram/
 */
public class P53_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        var chars = new int[26];

        for(var i = 0; i < s.length(); ++i){
            ++chars[s.charAt(i)-'a'];
            --chars[t.charAt(i)-'a'];
        }

        for(var i = 0; i < 26; ++i){
            if(chars[i] != 0)
                return false;
        }

        return true;
    }
}
