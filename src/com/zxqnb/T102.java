package com.zxqnb;

import java.util.*;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode lastNodePerLevel = root;
        List<Integer> nodesPerLevel = new ArrayList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            TreeNode curNode = q.pollFirst();
            nodesPerLevel.add(curNode.val);
            if (curNode.left != null) {
                q.offerLast(curNode.left);
            }
            if (curNode.right != null) {
                q.offerLast(curNode.right);
            }
            if (curNode == lastNodePerLevel) {
                ans.add(new ArrayList<>(nodesPerLevel));
                nodesPerLevel.clear();
                lastNodePerLevel = q.peekLast();
            }
        }
        return ans;
    }
}
