package com.zxqnb;

import java.util.Stack;

public class T331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            if (node.equals("#")) {
                while (stack.size() > 1 && stack.peek().equals("#")) {
                    stack.pop();
                    stack.pop();
                }
                if (stack.size() == 1 && stack.peek().equals("#")) {
                    return false;
                }
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerialization1(String preorder) {
        int i = 0, n = preorder.length();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        while (i < n) {
            if (s.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                i++;
                int top = s.pop() - 1;
                if (top > 0) {
                    s.push(top);
                }
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top=  s.pop() - 1;
                if (top > 0) {
                    s.push(top);
                }
                s.push(2);
            }
        }
        return s.isEmpty();
    }
}










































































