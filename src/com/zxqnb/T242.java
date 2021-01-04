package com.zxqnb;

public class T242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] tables = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (tables[index] == 0) {
                return false;
            }
            tables[index]--;
        }
        return true;
    }
}
