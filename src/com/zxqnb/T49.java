package com.zxqnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49 {
    /**
     * String中出现的字符及次数是可以用来划分group的，因此可以作为key
     * 时间、空间复杂度是O(n(k + 26))
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (cnt[i] != 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(cnt[i]);
                }
            }
            String key = sb.toString();
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(str);
            map.put(key, group);
        }
        return new ArrayList<>(map.values());
    }
}
