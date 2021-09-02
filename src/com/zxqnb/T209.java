package com.zxqnb;

import java.util.Arrays;

public class T209 {
    private int binarySearch(int[] a, int l, int r, int key) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] < key) {
                l = mid + 1;
            } else if(a[mid] > key) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        if (prefixSum[n] < target) {
            return 0;
        }
        int minLen = n;
        for (int i = 1; i <= n; i++) {
            int j = binarySearch(prefixSum, i, n - 1, target + prefixSum[i]);
            if (j < n) {
                minLen = Math.min(j - i + 2, minLen);
            }
        }
        return minLen;
    }
}
