package org.example.p_string;

/*
    Valid Palindrome
    https://leetcode.com/problems/valid-palindrome/
 */
public class P56_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;

        if(s.length() <= 1)
            return true;

        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            } else if(!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            } else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            else {
                ++left;
                --right;
            }
        }

        return true;
    }
}
