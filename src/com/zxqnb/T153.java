package com.zxqnb;

public class T153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                if (nums[mid] < nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
