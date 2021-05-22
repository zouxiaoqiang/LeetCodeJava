package com.zxqnb;

public class T8 {
    public int atoi(String s, boolean isNegative) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
        }
        if (isNegative) {
            sum = -sum;
            if (sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) sum;
    }

    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        boolean isNegative = false;
        char c = s.charAt(i);
        if (c == '-') {
            isNegative = true;
            i++;
        } else if (c == '+') {
            i++;
        } else if (c < '0' || c > '9') {
            return 0;
        }
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        int j = i;
        while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
            j++;
        }
        if (j == i) {
            return 0;
        }
        if (j - i > 10) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return atoi(s.substring(i, j), isNegative);
    }

    public static void main(String[] args) {
        new T8().myAtoi(" -42");
    }
}
