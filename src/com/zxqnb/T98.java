package com.zxqnb;

public class T98 {
    private boolean isValidBST(TreeNode root, long l, long r) {
        if (root == null) {
            return true;
        }
        if (root.val <= l || root.val >= r) {
            return false;
        }
        return isValidBST(root.left, l, root.val) && isValidBST(root.right, root.val, r);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, (long)Integer.MIN_VALUE - 1, root.val) && isValidBST(root.right, root.val, (long)Integer.MAX_VALUE + 1);
    }
}
