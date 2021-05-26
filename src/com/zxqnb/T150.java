package com.zxqnb;

import java.util.Stack;

public class T150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b + a);
            } else if ("-".equals(token)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b * a);
            } else if ("/".equals(token)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
