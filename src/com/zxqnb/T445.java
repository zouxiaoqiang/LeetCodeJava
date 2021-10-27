package com.zxqnb;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class T445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>(), num2 = new Stack<>();
        Stack<Integer> s = new Stack<>();
        while (l1 != null) {
            num1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.push(l2.val);
            l2 = l2.next;
        }
        int addition = 0;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int a = 0, b = 0;
            if (!num1.isEmpty()) {
                a = num1.pop();
            }
            if (!num2.isEmpty()) {
                b = num2.pop();
            }
            int sum = a + b + addition;
            s.push(sum % 10);
            addition = sum / 10;
        }
        if (addition != 0) {
            s.push(addition);
        }
        ListNode head = new ListNode(), curr = head;
        while (!s.isEmpty()) {
            curr.next = new ListNode(s.pop());
            curr = curr.next;
        }
        return head.next;
    }
}
