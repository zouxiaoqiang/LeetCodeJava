package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T241 {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length(), idx = 0;
        int num = 0;
        while (idx < n && Character.isDigit(expression.charAt(idx))) {
            num = num * 10 + (expression.charAt(idx) - '0');
            idx++;
        }
        List<Integer> res = new ArrayList<>();
        if (idx == n) {
            res.add(num);
            return res;
        }
        for (int i = idx; i < n; i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
            for (int l : left) {
                for (int r : right) {
                    if (ch == '+') {
                        res.add(l + r);
                    } else if (ch == '-') {
                        res.add(l - r);
                    } else if (ch == '*') {
                        res.add(l * r);
                    }
                }
            }
        }
        return res;
    }
}
