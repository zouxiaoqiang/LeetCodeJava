package com.zxqnb;

public class T231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int cnt = 0;
        while (n > 0 && cnt <= 1) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        T231 t = new T231();
        t.isPowerOfTwo(8);
    }
}
