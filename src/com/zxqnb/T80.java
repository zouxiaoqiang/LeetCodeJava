package com.zxqnb;

public class T80 {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 2, n = nums.length, gap;
        while (r < n) {
            while (r < n && nums[l] == nums[r]) {
                r++;
            }
            gap = r - l - 2;
            if (gap > 0) {
                for (int i = r; i < n; i++) {
                    nums[i - gap] = nums[i];
                }
                n -= gap;
                l = r - gap;
            } else {
                do {
                    l++;
                } while (l < n && nums[l] == nums[l - 1]);
            }
            r = l + 2;
        }
        return n;
    }
}
