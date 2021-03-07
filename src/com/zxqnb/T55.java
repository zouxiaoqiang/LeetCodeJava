package com.zxqnb;

public class T55 {
    // 贪心算法
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length && i <= maxPosition; i++) {
            if (maxPosition < i + nums[i]) {
                maxPosition = i + nums[i];
            }
        }
        return maxPosition >= nums.length - 1;
    }
}
