package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backTracking(int cur, int n, int[] nums) {
        for (int i = cur; i < n; i++) {
            if (i != cur + 1 && nums[i] == nums[i - 1]) {
                // 重复
                continue;
            }
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracking(i + 1, n, nums);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        int n = nums.length;
        backTracking(0, n, nums);
        return ans;
    }
}
