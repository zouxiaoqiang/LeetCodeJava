package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int startRow = 0, endRow = matrix.length, startCol = 0, endCol = matrix[0].length;
        while (startRow < endRow && startCol < endCol) {
            // 向右移动
            for (int y = startCol; y < endCol; y++) {
                ans.add(matrix[startRow][y]);
            }
            startRow++;
            // 向下移动
            for (int x = startRow; x < endRow; x++) {
                ans.add(matrix[x][endCol - 1]);
            }
            endCol--;
            if (startRow < endRow && startCol < endCol) {
                // 向左移动
                for (int y = endCol - 1; y >= startCol; y--) {
                    ans.add(matrix[endRow - 1][y]);
                }
                endRow--;
                // 向上移动
                for (int x = endRow - 1; x >= startRow; x--) {
                    ans.add(matrix[x][startCol]);
                }
                startCol++;
            }
        }
        return ans;
    }
}
