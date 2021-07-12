package com.zxqnb;

public class T221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0' || dp[i - 1][j - 1] == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    int e = (int) Math.sqrt(dp[i - 1][j - 1]);
                    int k = 1;
                    while (k <= e && matrix[i][j - k] != '0' && matrix[i - k][j] != '0') {
                        k++;
                    }
                    dp[i][j] = k * k;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println();
        return ans;
    }
}
