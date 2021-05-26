package com.zxqnb;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (r1 < l1) {
            return null;
        }
        int val = preorder[l1];
        TreeNode root = new TreeNode(val);
        int i = l2;
        while (i < r2 && inorder[i] != val) {
            i++;
        }
        root.left = buildTree(preorder, l1 + 1, l1 + i - l2, inorder, l2, i - 1);
        root.right = buildTree(preorder, l1 + i - l2 + 1, r1, inorder, i + 1, r2);
        return root;
    }

    private final Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree1(int[] preorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        int indexRoot = indexMap.get(preorder[l1]);
        TreeNode root = new TreeNode(preorder[l1]);
        root.left = buildTree1(preorder, l1 + 1, l1 + indexRoot - l2, l2, indexRoot - 1);
        root.right = buildTree1(preorder, l1 + indexRoot - l2 + 1, r1, indexRoot + 1, r2);
        return root;
    }

}
