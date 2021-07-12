package com.zxqnb;


public class T222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode cur = root;
        int height = 0;
        while (cur.left != null) {
            height++;
            cur = cur.left;
        }
        int l = 1 << height, r = (1 << (height + 1)) - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int flag = 1 << (height - 1);
            cur = root;
            while (cur != null && flag > 0) {
                if ((mid & flag) == 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
                flag >>= 1;
            }
            if (cur != null) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
