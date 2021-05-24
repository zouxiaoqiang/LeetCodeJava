package com.zxqnb;

public class T152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            if (maxF > ans) {
                ans = maxF;
            }
        }
        return ans;
    }
}
