package com.zxqnb;

import com.sun.tools.jdeps.JdepsFilter;

import java.util.*;

public class T199 {
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private List<Integer> ans;
    private boolean[] visited;

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (!visited[depth]) {
            ans.add(root.val);
            visited[depth] = true;
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int depth = getDepth(root);
        visited = new boolean[depth];
        ans = new ArrayList<>(depth);
        dfs(root, 0);
        return ans;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode last = queue.getLast();
            boolean visited = false;
            TreeNode curNode;
            do {
                curNode = queue.pollFirst();
                if (!visited) {
                    ret.add(curNode.val);
                    visited = true;
                }
                if (curNode.right != null) {
                    queue.offerLast(curNode.right);
                }
                if (curNode.left != null) {
                    queue.offerLast(curNode.left);
                }
            } while (curNode != last);
        }
        return ret;
    }
}
