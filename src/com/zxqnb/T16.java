package com.zxqnb;

import java.util.Arrays;

public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1, sum;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (closest > Math.abs(sum - target)) {
                    ans = sum;
                    closest = Math.abs(sum - target);
                }
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}
