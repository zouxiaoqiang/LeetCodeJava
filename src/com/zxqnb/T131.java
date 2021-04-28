package com.zxqnb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T131 {
    private boolean[][] dp;
    private int n;
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> partitionList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(final String s, int start) {
        if (start == n) {
            ans.add(new ArrayList<>(partitionList));
            return;
        }
        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                partitionList.add(s.substring(start, i + 1));
                dfs(s, i + 1);
                partitionList.remove(partitionList.size() - 1);
            }
        }
    }

}
