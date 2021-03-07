package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {
    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 如果i>start，说明i-1和i不在同一条path上，因此可以舍去防止重复
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target >= candidates[i]) {
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], path, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, path, 0);
        return ans;
    }
}
