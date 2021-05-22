package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T113 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, target);
            dfs(root.right, target);
        }
        path.remove(path.size() - 1);
    }
}
