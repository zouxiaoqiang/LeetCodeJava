package com.zxqnb;

import java.util.*;

public class T144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            ans.add(cur.val);
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }
}
