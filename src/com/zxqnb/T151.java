package com.zxqnb;

import java.util.Stack;

public class T151 {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<String> wordsStack = new Stack<>();
        int i = 0, n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i == n) {
                break;
            }
            int j = i;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            wordsStack.push(s.substring(j, i));
        }
        while (!wordsStack.isEmpty()) {
            ans.append(wordsStack.pop()).append(' ');
        }
        return ans.substring(0, ans.length() - 1);
    }
}
