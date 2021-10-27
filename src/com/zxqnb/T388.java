package com.zxqnb;

import java.util.Stack;

public class T388 {


    public int lengthLongestPath(String input) {
        int longestPath = 0, curLen = 0;
        int i = 0, len = input.length();
        boolean isFile = false;
        Stack<String> s = new Stack<>();
        while (i < len) {
            char ch = input.charAt(i);
            if (ch == '\n') {
                int size = 0;
                while (input.charAt(++i) == '\t') {
                    size++;
                }
                while (s.size() > size) {
                    String peek = s.pop();
                    curLen -= peek.length();
                }
            } else {
                int j = i;
                while (j < len && input.charAt(j) != '\n') {
                    if (input.charAt(j) == '.') {
                        isFile = true;
                    }
                    j++;
                }
                if (isFile) {
                    curLen += j - i;
                    longestPath = Math.max(longestPath, curLen);
                    isFile = false;
                    s.push(input.substring(i, j));
                } else {
                    curLen += j - i + 1;
                    s.push(input.substring(i, j) + '/');
                }
                i = j;
            }
        }
        return longestPath;
    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(new T388().lengthLongestPath(s));
    }
}
