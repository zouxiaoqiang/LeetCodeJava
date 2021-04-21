package com.zxqnb;

import java.util.List;

public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            List<Integer> level = triangle.get(i);
            int n = level.size();
            for (int j = 0; j < n; j++) {
                int preMin;
                if (j == 0) {
                    preMin = dp[i - 1][j];
                } else if (j == n - 1) {
                    preMin = dp[i - 1][j - 1];
                } else {
                    preMin = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                dp[i][j] = triangle.get(i).get(j) + preMin;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < row; j++) {
            ans = Math.min(ans, dp[row - 1][j]);
        }
        return ans;
    }
}
