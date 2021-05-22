package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T93 {
    private List<String> ans = new ArrayList<>();
    private static final int SEG_CNT = 4;
    private int[] segments = new int[SEG_CNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segStart, int segId) {
        if (segId == SEG_CNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_CNT; i++) {
                    sb.append(segments[i]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
            }
            return;
        }
        if (s.length() == segStart) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segStart + 1, segId + 1);
        } else {
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                if (addr <= 0xFF) {
                    segments[segId] = addr;
                    dfs(s, segEnd + 1, segId + 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new T93().restoreIpAddresses("25525511135");
    }
}
