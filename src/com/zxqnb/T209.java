package com.zxqnb;

public class T209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) {
            return 1;
        }
        int size = nums.length, minLen = Integer.MAX_VALUE;
        int sum = 0, r = 0, l = 0;
        while (r < size) {
            sum += nums[r];
            while (sum - nums[l] >= target) {
                sum -= nums[l++];
            }
            if (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (sum[n] < target) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int bound = binarySearch(sum, target + sum[i - 1]);
            if (bound != -1) {
                minLen = Math.min(minLen, bound - (i - 1));
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int binarySearch(int[] a, int k) {
        int l = 0, r = a.length - 1, mid;
        if (a[r] < k) {
            return -1;
        }
        while (l < r) {
            mid = (l + r) >> 1;
            if (a[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return a[l] >= k ? l : -1;
    }
}
