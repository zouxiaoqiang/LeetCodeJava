package com.zxqnb;

public class T48 {
    /**
     * 顺时针旋转90度相当于先做对角线翻转，再做垂直翻转
     */
    public void rotate(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int tmp;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = tmp;
            }
        }
    }
}
