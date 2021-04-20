package com.zxqnb;

import java.util.HashMap;
import java.util.Map;

public class T106 {
    private final Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, n - 1, postorder, 0, n - 1);
    }
    private TreeNode buildTree(int inorderL, int inorderR, int[] postorder, int postorderL, int postorderR) {
        if (inorderL > inorderR) {
            return null;
        }
        int val=  postorder[postorderR];
        int indexRoot = indexMap.get(val);
        TreeNode root = new TreeNode(postorder[postorderR]);
        root.left = buildTree(inorderL, indexRoot - 1, postorder, postorderL, postorderL + indexRoot - inorderL - 1);
        root.right=  buildTree(indexRoot + 1, inorderR, postorder, postorderL + indexRoot - inorderL, postorderR - 1);
        return root;
    }
}
