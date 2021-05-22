package com.zxqnb;

public class T92 {
    private ListNode post, pre;
    private ListNode reverse(ListNode head, int start, int end) {
        if (start == end) {
            post = head.next;
            pre.next = head;
        } else {
            ListNode next = reverse(head.next, start + 1, end);
            next.next = head;
        }
        return head;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        pre = new ListNode(0, head);
        head = pre;
        int cnt = 1;
        while (pre != null && cnt < left) {
            pre = pre.next;
            cnt++;
        }
        reverse(pre.next, left, right).next = post;
        return head.next;
    }
}
