package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = nums[0], r;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                r = nums[i - 1];
                if (r == l) {
                    ans.add(String.valueOf(l));
                } else {
                    ans.add(l + "->" + r);
                }
                l = nums[i];
            }
        }
        if (l == nums[nums.length - 1]) {
            ans.add(String.valueOf(l));
        } else {
            ans.add(l + "->" + nums[nums.length - 1]);
        }
        return ans;
    }
}
