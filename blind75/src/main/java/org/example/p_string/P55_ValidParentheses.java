package org.example.p_string;

import java.util.Stack;

/*
    Valid Parentheses
    https://leetcode.com/problems/valid-parentheses/
 */
public class P55_ValidParentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (stack.isEmpty())
                return false;
            else {
                if (c == ')' && stack.pop() != '(') return false;
                if (c == '}' && stack.pop() != '{') return false;
                if (c == ']' && stack.pop() != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
