package com.zxqnb;

public class T237 {
    public void deleteNode(ListNode node) {
        ListNode cur = node, next = node.next;
        while (next.next != null) {
            cur.val = next.val;
            cur = next;
            next = next.next;
        }
        cur.val = next.val;
        cur.next = null;
    }
}
