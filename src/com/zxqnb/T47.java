package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {
    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int[] nums, boolean[] visited, List<Integer> l, int depth) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                l.add(nums[i]);
                dfs(nums, visited, l, depth + 1);
                l.remove(l.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited, new ArrayList<>(), 0);
        return ans;
    }
}
