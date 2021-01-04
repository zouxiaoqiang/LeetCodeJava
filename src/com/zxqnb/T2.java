package com.zxqnb;

public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0), cur = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            carry = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                carry = 1;
                sum %= 10;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return l3.next;
    }
}
