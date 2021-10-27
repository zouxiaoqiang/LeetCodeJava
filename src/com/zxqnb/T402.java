package com.zxqnb;

import java.util.Deque;
import java.util.LinkedList;

public class T402 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (k >= length) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T402().removeKdigits("1432219", 3));
    }
}
