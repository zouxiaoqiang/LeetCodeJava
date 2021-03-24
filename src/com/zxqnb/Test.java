package com.zxqnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static int ans;

    private static boolean leastStep(int cur, int n, int step) {
        if (cur > n) {
            return false;
        }
        if (cur == n) {
            ans = step;
            return true;
        }
        if (leastStep(cur * 3, n, step + 1)) {
            return true;
        }
        if (leastStep(cur * 2, n, step + 1)) {
            return true;
        }
        return leastStep(cur + 1, n, step + 1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            leastStep(1, arr[i], 1);
            System.out.println(ans);
        }
    }
}
