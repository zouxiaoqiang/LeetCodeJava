package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    private void backTracking(int cur, int[] nums) {
        ans.add(new ArrayList<>(subset));
        for (int i = cur; i < nums.length; i++) {
            subset.add(nums[i]);
            backTracking(i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }

    private List<List<Integer>> bitManipulation(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            subset.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(subset));
        }
        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(0, nums);
        return ans;
    }
}
