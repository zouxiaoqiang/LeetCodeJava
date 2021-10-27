package com.zxqnb;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class T456 {
    // 枚举3
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        int minLeft = nums[0];
        for (int i = 2; i < n; i++) {
            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            if (minLeft < nums[i]) {
                Integer next = rightAll.ceilingKey(minLeft + 1);
                if (next != null && next < nums[i]) {
                    return true;
                }
            }
            minLeft = Math.min(minLeft, nums[i]);
            rightAll.put(nums[i + 1], rightAll.get(nums[i + 1]) - 1);
            if (rightAll.get(nums[i + 1]) == 0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }

    // 枚举2
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[n - 1]);
        int max2 = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < max2) {
                return true;
            }
            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                max2 = deque.pop();
            }
            if (nums[i] > max2) {
                deque.push(nums[i]);
            }
        }
        return false;
    }
}
