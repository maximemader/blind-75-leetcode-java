package org.example.p_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Group Anagrams
    https://leetcode.com/problems/group-anagrams/
 */
public class P54_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        var map = new HashMap<String, List<String>>();

        // Since we have only ASCII lowercase letters, we can go a bit faster
        // by sorting characters instead of reusing P53_ValidAnagram.java.
        for (var str : strs) {

            var strArray = str.toCharArray();
            Arrays.sort(strArray);
            var key = new String(strArray);

            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return map.values().stream().toList();
    }
}
