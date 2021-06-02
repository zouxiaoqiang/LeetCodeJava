package com.zxqnb;

public class T189 {
    private void reverse(int[] a, int l, int r) {
        int tmp;
        while (l < r) {
            tmp = a[l];
            a[l++] = a[r];
            a[r--] = tmp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private int gcd(int a, int b) {
        int r;
        do {
            r = a % b;
            a = b;
            b = r;
        } while (b > 0);
        return a;
    }


    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int epoch = gcd(n ,k);
        for (int i = 0; i < epoch; i++) {
            int curr = i, prev = nums[i];
            do {
                int next = (curr + k) % n;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curr = next;
            } while (curr != i);
        }
    }
}
