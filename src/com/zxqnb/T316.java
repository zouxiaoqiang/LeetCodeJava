package com.zxqnb;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T316 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] remainChars = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            remainChars[s.charAt(i) - 'a']++;
        }
        Deque<Character> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (!q.isEmpty() && q.peekLast() > ch && remainChars[q.peekLast() - 'a'] > 0) {
                    vis[q.removeLast() - 'a'] = false;
                }
                vis[ch - 'a'] = true;
                q.offerLast(ch);
            }
            remainChars[ch - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.removeFirst());
        }
        return sb.toString();
    }
}
