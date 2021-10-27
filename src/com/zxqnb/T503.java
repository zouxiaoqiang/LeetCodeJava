package com.zxqnb;

import java.util.*;

public class T503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    // 不要局限于一开始就构建单调栈，可以一边遍历一边构建
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }
        int[] ret = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // 保证栈局部单调不升
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }

}