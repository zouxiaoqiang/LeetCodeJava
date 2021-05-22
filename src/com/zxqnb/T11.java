package com.zxqnb;


public class T11 {
    public int maxArea(int[] height) {
        int maxArea = 0, n = height.length;
        for (int i = 0; i < n - 1; i++) {
            int curArea = 0;
            for (int j = i + 1; j < n; j++) {
                if (height[j] < height[i]) {
                    curArea = Math.max(curArea, (j - i) * height[j]);
                } else {
                    curArea = (j - i) * height[i];
                }
            }
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    // 双指针的做法：只要想明白下一步怎么走才有可能找到新的容器边界就简单了
    public int maxArea1(int []height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                maxArea = Math.max(maxArea, (r - l) * height[l]);
                l++;
            } else {
                maxArea = Math.max(maxArea, (r - l) * height[r]);
                r--;
            }
        }
        return maxArea;
    }
}
