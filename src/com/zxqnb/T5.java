package com.zxqnb;

public class T5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int[] range = {0, 0};
        // 必须从低间隔向高间隔递推
        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                boolean eq = s.charAt(i) == s.charAt(i + l);
                if (l == 0) {
                    dp[i][i + l] = true;
                } else if (l == 1) {
                    dp[i][i + l] = eq;
                } else {
                    dp[i][i + l] = eq && dp[i + 1][i + l - 1];
                }
                if (dp[i][i + l] && l + 1 > maxLen) {
                    range[0] = i;
                    range[1] = i + l + 1;
                    maxLen = l + 1;
                }
            }
        }
        return s.substring(range[0], range[1]);
    }

    public static void main(String[] args) {
        T5 t = new T5();
        t.longestPalindrome("aaaaa");
    }
}
