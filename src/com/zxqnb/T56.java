package com.zxqnb;

import java.util.*;

public class T56 {
    // a <= b -> 1, otherwise  -> -1
    private int compare(int[] a, int[] b) {
        return Integer.compare(b[0], a[0]);
    }

    private void myQuickSort(int[][] a, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int[] x = a[i];
            while (i < j) {
                while (i < j && compare(x, a[j]) >= 0) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && compare(x, a[i]) == -1) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            myQuickSort(a, l, i - 1);
            myQuickSort(a, i + 1, r);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o2[0] - o1[0]);
        myQuickSort(intervals, 0, intervals.length - 1);
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if (intervals[i][1] > ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
