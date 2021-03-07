package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T39 {

    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * 通过设置start可以防止出现重复组合
     */
    private void backTracking(int[] candidates, int target, List<Integer> l, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                l.add(candidates[i]);
                backTracking(candidates, target - candidates[i], l, i);
                l.remove(l.size() - 1);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList<>();
        backTracking(candidates, target, l, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(new T39().combinationSum(candidates, 7));
    }
}
