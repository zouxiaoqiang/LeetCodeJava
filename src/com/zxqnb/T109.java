package com.zxqnb;

public class T109 {
    private ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        return buildTree(0, n - 1);
    }

    private TreeNode buildTree(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(l, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, r);
        return root;
    }
}
