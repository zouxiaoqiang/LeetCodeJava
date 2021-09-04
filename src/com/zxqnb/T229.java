package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int cand1 = nums[0], cnt1 = 0;
        int cand2 = nums[0], cnt2 = 0;
        for (int num : nums) {
            if (cand1 == num) {
                cnt1++;
                continue;
            }
            if (cand2 == num) {
                cnt2++;
                continue;
            }
            if (cnt1 == 0) {
                cand1 = num;
                cnt1++;
                continue;
            }
            if (cnt2 == 0) {
                cand2 = num;
                cnt2++;
                continue;
            }
            cnt1--;
            cnt2--;
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num: nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            }
        }
        if (cnt1 > nums.length / 3) {
            ret.add(cand1);
        }
        if (cnt2 > nums.length / 3) {
            ret.add(cand2);
        }
        return ret;
    }
}
