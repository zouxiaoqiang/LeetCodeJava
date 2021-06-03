package com.zxqnb;

public class T201 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd1(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
