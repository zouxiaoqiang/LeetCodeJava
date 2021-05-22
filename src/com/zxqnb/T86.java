package com.zxqnb;

public class T86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0), small = smallHead, large = largeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
