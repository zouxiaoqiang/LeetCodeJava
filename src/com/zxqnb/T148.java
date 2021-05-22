package com.zxqnb;

import java.util.List;

public class T148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode l1 = sortList(head, slow);
        ListNode l2 = sortList(slow, tail);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead, curr1 = head1, curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if (curr1 != null) {
            curr.next = curr1;
        } else if (curr2 != null) {
            curr.next = curr2;
        }
        return dummyHead.next;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead;
            cur = dummyHead.next;
            while (cur != null) {
                ListNode l1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode l2 = cur.next;
                cur.next = null;
                cur = l2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                if (cur != null) {
                    ListNode next = cur.next;
                    cur.next = null;
                    cur = next;
                }
                prev.next = merge(l1, l2);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummyHead.next;
    }
}
