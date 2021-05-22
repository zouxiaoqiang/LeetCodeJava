package com.zxqnb;

public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }
        int l = 0, r = row - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][0] < target) {
                l = mid + 1;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        int x = r;
        // 在l+1行寻找target
        if (matrix[x][col - 1] < target) {
            return false;
        }
        l = 0;
        r = col - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[x][mid] < target) {
                l = mid + 1;
            } else if (matrix[x][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        new T74().searchMatrix(m, 13);
    }
}
