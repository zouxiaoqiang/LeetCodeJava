package com.zxqnb;

public class T64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] pathSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pathSum[i][j] = pathSum[i][j];
                if (i > 0 && j > 0) {
                    pathSum[i][j] += Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);
                } else if (i > 0) {
                    pathSum[i][j] += pathSum[i - 1][j];
                } else if (j > 0) {
                    pathSum[i][j] += pathSum[i][j - 1];
                }
            }
        }
        return pathSum[n - 1][m - 1];
    }
}
