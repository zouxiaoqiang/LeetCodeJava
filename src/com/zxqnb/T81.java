package com.zxqnb;

public class T81 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 分不清前面有序还是后面有序
            if (nums[mid] == nums[l]) {
                l++;
                continue;
            }
            // 前半部分有序
            if (nums[l] < nums[mid]) {
                // target在前半部分
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 后半部分有序
                // target在后半部分
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
