package com.zxqnb;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class T220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> bucket = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (bucket.containsKey(id)) {
                return true;
            } else if (bucket.containsKey(id - 1) && Math.abs(nums[i] - bucket.get(id - 1)) < w) {
                return true;
            } else if (bucket.containsKey(id + 1) && Math.abs(nums[i] - bucket.get(id + 1)) < w) {
                return true;
            }
            bucket.put(id, (long)nums[i]);
            if (i >= k) {
                bucket.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    private long getID(long i, long w) {
        if (i >= 0) {
            return i / w;
        }
        return (i + 1) / w - 1;
    }
}
