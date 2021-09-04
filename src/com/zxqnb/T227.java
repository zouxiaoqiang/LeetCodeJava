package com.zxqnb;

import java.util.Stack;

public class T227 {
    private int cal(char c, int a, int b) {
        if (c == '*') {
            return a * b;
        } else if (c == '/') {
            return a / b;
        } else if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        }
        return -1;
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> op = new Stack<>();
        int i = 0, len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int j = i + 1;
                while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                nums.push(Integer.valueOf(s.substring(i, j)));
                i = j;
                continue;
            } else if (c == '+' || c == '-') {
                while (!op.isEmpty()) {
                    int b = nums.pop(), a = nums.pop();
                    char top = op.pop();
                    nums.push(cal(top, a, b));
                }
                op.push(c);
            } else if (c == '*' || c == '/') {
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    int b = nums.pop(), a = nums.pop();
                    char top = op.pop();
                    nums.push(cal(top, a, b));
                }
                op.push(c);
            }
            i++;
        }
        while (!op.isEmpty()) {
            char top = op.pop();
            int b = nums.pop(), a = nums.pop();
            nums.push(cal(top, a, b));
        }
        return nums.peek();
    }

    public static void main(String[] args) {
        System.out.println(new T227().calculate("3+2 * 2"));
    }
}
