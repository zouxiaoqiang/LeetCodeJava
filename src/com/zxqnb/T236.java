package com.zxqnb;

import java.util.*;

public class T236 {
    // 自底向上的递归方法
    /*
     private TreeNode ans = null;

     private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
     if (root == null) {
     return false;
     }
     boolean lSon = dfs(root.left, p, q);
     boolean rSon = dfs(root.right, p, q);
     if ((lSon && rSon) || ((lSon || rSon) && (root.val == p.val || root.val == q.val))) {
     ans = root;
     }
     return lSon || rSon || root.val == p.val || root.val == q.val;
     }

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     dfs(root, p, q);
     return ans;
     }
     */

    // 存储节点的父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

}
