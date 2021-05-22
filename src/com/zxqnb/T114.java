package com.zxqnb;


import java.util.Deque;
import java.util.LinkedList;

public class T114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = new TreeNode();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            prev.right = curr;
            prev.left = null;
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            prev = curr;
        }
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while(curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
