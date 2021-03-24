package com.zxqnb;

public class T75 {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, len = nums.length, tmp;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = tmp;
            } else if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, tmp;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }
}
