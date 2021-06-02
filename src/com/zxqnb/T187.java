package com.zxqnb;

import java.util.*;

public class T187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n < L) {
            return new ArrayList<>();
        }
        int a = 4, aL = (int) Math.pow(a, L);
        Map<Character, Integer> ch2Int = new HashMap<Character, Integer>(4) {
            {
                put('A', 0);
                put('C', 1);
                put('G', 2);
                put('T', 3);
            }
        };
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ch2Int.get(s.charAt(i));
        }
        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> out = new HashSet<>();
        for (int i = 0; i < n - L + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    h = h * a + nums[j];
                }
            } else {
                h = h * a - nums[i - 1] * aL + nums[i + L - 1];
            }
            if (seen.contains(h)) {
                out.add(s.substring(i, i + L));
            } else {
                seen.add(h);
            }
        }
        return new ArrayList<>(out);
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        int L = 10, n = s.length();
        if (n < L) {
            return new ArrayList<>();
        }
        Map<Character, Integer> ch2Int = new HashMap<Character, Integer>(4) {
            {
                put('A', 0);
                put('C', 1);
                put('G', 2);
                put('T', 3);
            }
        };
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ch2Int.get(s.charAt(i));
        }
        Set<Integer> seen = new HashSet<>();
        Set<String> out = new HashSet<>();
        int bitmask = 0;
        for (int i = 0; i < n - L + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    bitmask <<= 2;
                    bitmask |= nums[j];
                }
            } else {
                bitmask <<= 2;
                bitmask |= nums[i + L - 1];
                bitmask &= ~(3 << 2 * L);
            }
            if (seen.contains(bitmask)) {
                out.add(s.substring(i, i + L));
            } else {
                seen.add(bitmask);
            }
        }
        return new ArrayList<>(out);
    }

    public static void main(String[] args) {
        new T187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
