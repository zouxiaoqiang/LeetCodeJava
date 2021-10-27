package com.zxqnb;

import java.util.Collections;
import java.util.Stack;

public class T394 {
    public String decodeString(String s) {
        Stack<String> dataStack = new Stack<>();
        Stack<Integer> timesStack = new Stack<>();
        int i = 0, size = s.length();
        while (i < size) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int k = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
                timesStack.push(k);
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!dataStack.peek().equals("[")) {
                    sb.insert(0, dataStack.pop());
                }
                dataStack.pop();
                int k = timesStack.pop();
                dataStack.push(String.join("", Collections.nCopies(k, sb.toString())));
                i++;
            } else if (ch >= 'a' && ch <= 'z') {
                int j = i + 1;
                while (j < size && s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    j++;
                }
                dataStack.push(s.substring(i, j));
                i = j;
            } else if (ch == '[') {
                dataStack.push("[");
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dataStack.isEmpty()) {
            sb.insert(0, dataStack.pop());
        }
        return sb.toString();
    }
}
