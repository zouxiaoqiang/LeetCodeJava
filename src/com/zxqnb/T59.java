package com.zxqnb;

public class T59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int tar = n * n, k = 1;
        while (k <= tar) {
            for (int y = left; y <= right; y++, k++) {
                ans[top][y] = k;
            }
            top++;
            for (int x = top; x <= bottom; x++, k++) {
                ans[x][right] = k;
            }
            right--;
            for (int y = right; y >= left; y--, k++) {
                ans[bottom][y] = k;
            }
            bottom--;
            for (int x = bottom; x >= top; x--, k++) {
                ans[x][left] = k;
            }
            left++;
        }
        return ans;
    }
}
