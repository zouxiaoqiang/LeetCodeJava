package com.zxqnb;

public class T268 {
    public int missingNumber(int[] nums) {
        int n = nums.length * (nums.length + 1) / 2, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return n - sum;
    }
}
