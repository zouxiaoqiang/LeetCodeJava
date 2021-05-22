package com.zxqnb;

public class T50 {
    // 递归法
    private double quicklyPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quicklyPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    // 迭代法
    private double quicklyPow1(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        return n >= 0 ? quicklyPow1(x, n) : 1.0 / quicklyPow1(x, -(long) n);
    }
}
