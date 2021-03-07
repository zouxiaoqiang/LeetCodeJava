package com.zxqnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T12 {
    // 从大到小依次遍历
    public String intToRoman(int num) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < vals.length && num > 0; i++) {
            while (vals[i] <= num) {
                num -= vals[i];
                ans.append(symbols[i]);
            }
        }
        return ans.toString();
    }
}
