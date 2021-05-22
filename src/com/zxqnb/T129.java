package com.zxqnb;

public class T129 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += pathSum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, pathSum);
        }
        if (root.right != null) {
            dfs(root.right, pathSum);
        }

    }
}
