package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T17 {
    private List<ArrayList<Character>> m = new ArrayList<>() {
        {
            add(new ArrayList<>());
            add(new ArrayList<>());
            add(new ArrayList<>(Arrays.asList('a', 'b', 'c')));
            add(new ArrayList<>(Arrays.asList('d', 'e', 'f')));
            add(new ArrayList<>(Arrays.asList('g', 'h', 'i')));
            add(new ArrayList<>(Arrays.asList('j', 'k', 'l')));
            add(new ArrayList<>(Arrays.asList('m', 'n', 'o')));
            add(new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
            add(new ArrayList<>(Arrays.asList('t', 'u', 'v')));
            add(new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        }
    };

    private void dfs(List<String> comb, StringBuilder sb, List<ArrayList<Character>> mapping, int depth, int n) {
        if (depth == n) {
            comb.add(sb.toString());
        } else {
            ArrayList<Character> l = mapping.get(depth);
            for (Character c : l) {
                sb.append(c);
                dfs(comb, sb, mapping, depth + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        List<ArrayList<Character>> mapping = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            if (digit != 1) {
                mapping.add(m.get(digits.charAt(i) - '0'));
            }
        }
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, mapping, 0, mapping.size());
        return ans;
    }

    public static void main(String[] args) {
        new T17().letterCombinations("132");
    }
}
