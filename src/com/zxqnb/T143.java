package com.zxqnb;

public class T143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = getMiddleListNode(head);
        ListNode l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseListNode(l2);
        mergeListNode(l1, l2);
    }

    private ListNode getMiddleListNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void mergeListNode(ListNode l1, ListNode l2) {
        ListNode tmpL1, tmpL2;
        while (l1 != null && l2 != null) {
            tmpL1 = l1.next;
            tmpL2 = l2.next;
            l1.next = l2;
            l1 = tmpL1;
            l2.next = l1;
            l2 = tmpL2;
        }
    }

}
