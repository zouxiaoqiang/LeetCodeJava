package com.zxqnb;

import java.util.*;

public class T179 {
    public String largestNumber(int[] nums) {
        List<String> strNums = new ArrayList<>(nums.length);
        for (int i : nums) {
            strNums.add(String.valueOf(i));
        }
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2, s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        strNums.sort(myComparator);
        StringBuilder ans = new StringBuilder();
        for (String s: strNums) {
            ans.append(s);
        }
        String ret = ans.toString();
        if (ret.charAt(0) == '0') {
            return "0";
        }
        return ret;
    }
}
