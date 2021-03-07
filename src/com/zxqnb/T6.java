package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T6 {
    // 最蠢的做法，完全模拟之字形。
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 粗略估计最多需要多少空间存储s
        int cols = (s.length() / numRows + 1) * (numRows - 1);
        char[][] ch = new char[numRows][cols];
        int k = 0, j = 0;
        while (k < s.length()) {
            int remainder = j % (numRows - 1);
            if (remainder == 0) {
                for (int i = 0; i < numRows && k < s.length(); i++) {
                    ch[i][j] = s.charAt(k++);
                }
            } else {
                ch[numRows - 1 - remainder][j] = s.charAt(k++);
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (j = 0; j < cols; j++) {
                if (ch[i][j] != 0) {
                    sb.append(ch[i][j]);
                }
            }
        }
        return sb.toString();
    }


    /**
     * 找规律。找每一行字符对应的索引
     * 第0行，位于索引k*(2*numRows-2)处
     * 第numRows-1行， 位于索引k*(2*numRows - 2)+numRows-1处
     * 第i行，位于索引k*(2*numRows-2)+i和(k+1)(2*numRows-2)-i处
     */
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int n = s.length(), cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < n; j += cycleLen) {
                ans.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ans.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ans.toString();
    }

    /**
     * 把之字形看成是一个上下来回扫描的过程
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        // 一个改变方向的小技巧
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                goingDown = !goingDown;
            }
            i += goingDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
