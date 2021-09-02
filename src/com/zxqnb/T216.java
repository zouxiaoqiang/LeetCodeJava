package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T216 {
    private List<List<Integer>> ans;
    private boolean[] visited;
    private List<Integer> comb;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        if (n <= k || n >= k * 9) {
            return ans;
        }
        visited = new boolean[10];
        comb = new ArrayList<>();
        dfs(k, n, 1);
        return ans;
    }

    private void dfs(int k, int n, int start) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(comb));
            }
            return;
        }
        if (n <= 0) {
            return;
        }
        for (int i = start; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb.add(i);
                dfs(k - 1, n - i, i + 1);
                comb.remove(comb.size() - 1);
                visited[i] = false;
            }
        }
    }

}
