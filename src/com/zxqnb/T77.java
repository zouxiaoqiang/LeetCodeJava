package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class T77 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private boolean[] visited;

    private void dfs(Integer[] l, int cur, int n, int k) {
        // 剪枝，当前长度+剩余长度<k，则此路不通
        if (cur > 0 && cur + n - l[cur - 1] < k) {
            return;
        }
        if (cur == k) {
            ans.add(new ArrayList<>(Arrays.asList(l)));
            return;
        }
        int i = 1;
        if (cur != 0) {
            i = l[cur - 1];
        }
        for (; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                l[cur] = i;
                dfs(l, cur + 1, n, k);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n + 1];
        Integer[] path = new Integer[k];
        dfs(path, 0, n, k);
        return ans;
    }
}
