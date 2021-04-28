package com.zxqnb;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int cnt = 0, sumGas = 0, sumCost = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            }
            i = i + cnt + 1;
        }
        return -1;
    }
}
