package com.zxqnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 3) {
            return ans;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return ans;
        }
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r && nums[r] >= 0) {
                if (target < nums[l] + nums[r]) {
                    r--;
                } else if (target > nums[l] + nums[r]) {
                    l++;
                } else {
                    if (ans.size() > 0) {
                        List<Integer> list = ans.get(ans.size() - 1);
                        if (list.get(0) == nums[i] && list.get(1) == nums[l] && list.get(2) == nums[r]) {
                            l++;
                            r--;
                            continue;
                        }
                    }
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
