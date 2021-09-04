package com.zxqnb;

public class T230 {
    private int numOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + numOfNodes(root.left) + numOfNodes(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int numOfLeft = numOfNodes(root.left);
        if (numOfLeft > k - 1) {
            return kthSmallest(root.left, k);
        } else if (numOfLeft < k - 1) {
            return kthSmallest(root.right, k - numOfLeft - 1);
        } else {
            return root.val;
        }
    }
}
