package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int l = newInterval[0], r = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            // 在新区间左侧
            if (l > interval[1]) {
                ans.add(interval);
            } else if (r < interval[0]) {
                // 在新区间右侧，要判断是不是右侧第一个区间
                if (!placed) {
                    ans.add(new int[]{l, r});
                    placed = true;
                }
                ans.add(interval);
            } else {
                // 有交集的区间
                if (interval[0] < l) {
                    l = interval[0];
                }
                if (interval[1] > r) {
                    r = interval[1];
                }
            }
        }
        if (!placed) {
            ans.add(new int[]{l, r});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
