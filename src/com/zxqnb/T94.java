package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T94 {
    private List<Integer> ans = new ArrayList<>();
    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            ans.add(root.val);
            inorder(root.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }
}
