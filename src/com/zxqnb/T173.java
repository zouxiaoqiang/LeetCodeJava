package com.zxqnb;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T173 {
    class BSTIterator {

        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ans = cur.val;
            cur = cur.right;
            return ans;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
