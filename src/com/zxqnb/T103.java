package com.zxqnb;

import java.util.*;

public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean fromLeft = false;
        while (!stack.isEmpty()) {
            List<TreeNode> nodesPerLevel = new ArrayList<>();
            List<Integer> nodeValPerLevel = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                nodeValPerLevel.add(curNode.val);
                nodesPerLevel.add(curNode);
            }
            ans.add(new ArrayList<>(nodeValPerLevel));
            if (fromLeft) {
                for (TreeNode node : nodesPerLevel) {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            } else {
                for (TreeNode node : nodesPerLevel) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            fromLeft = !fromLeft;
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isLeftOrder = true;
        while (!q.isEmpty()) {
            Deque<Integer> nodeValPerLevel= new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if (isLeftOrder) {
                    nodeValPerLevel.offerLast(curNode.val);
                } else {
                    nodeValPerLevel.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            ans.add(new LinkedList<>(nodeValPerLevel));
            isLeftOrder = !isLeftOrder;
        }
        return ans;
    }
}
