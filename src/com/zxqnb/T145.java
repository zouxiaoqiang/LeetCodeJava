package com.zxqnb;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T145 {
    /**
     * 要注意读取结点的时机
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, prev = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                ans.add(node.val);
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return ans;
    }
}
