package com.zxqnb;

public class T82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode(0, head);
        ListNode p = ans, q = head;
        while (q != null) {
            q = q.next;
            while (q != null && p.next.val == q.val) {
                q = q.next;
            }
            // 不重复
            if (p.next.next == q) {
                p = p.next;
            }
            p.next = q;
        }
        return ans.next;
    }
}
