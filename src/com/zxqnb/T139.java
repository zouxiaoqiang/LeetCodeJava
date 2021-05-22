package com.zxqnb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxWordLen = 0;
        int minWordLen = Integer.MAX_VALUE;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (String word : wordDict) {
            maxWordLen = Math.max(maxWordLen, word.length());
            minWordLen = Math.min(minWordLen, word.length());
        }
        for (int i = 1; i <= s.length(); i++) {
            int end = i - minWordLen + 1;
            int j = Math.max(0, i - maxWordLen);
            while (j < end) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                j++;
            }
        }
        return dp[s.length()];
    }
}
