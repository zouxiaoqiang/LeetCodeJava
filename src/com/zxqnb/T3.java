package com.zxqnb;

import java.util.HashSet;
import java.util.Set;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int len = 1;
        int l = 0, r = 1;
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                while (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                if (len < r - l) {
                    len = r - l;
                }
                l++;
            } else {
                set.add(s.charAt(r));
            }
            r++;
        }
        return len;
    }
}
