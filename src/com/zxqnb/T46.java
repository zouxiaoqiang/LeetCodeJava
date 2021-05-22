package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T46 {
    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int[] nums, boolean[] visited, List<Integer> l, int depth) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                l.add(nums[i]);
                dfs(nums, visited, l, depth + 1);
                l.remove(l.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), 0);
        return ans;
    }
}
