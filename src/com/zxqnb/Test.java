package com.zxqnb;

import java.util.Arrays;
import java.util.Scanner;

class User implements Comparable {
    int id;
    int time;
    int base;

    User(int id, int time) {
        this.id = id;
        this.time = time;
        this.base = time;
    }

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        return Integer.compare(this.time, u.time);
    }
}

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        User[] arr = new User[n];
        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            arr[i] = new User(i + 1, time);
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[0].id);
            arr[0].time += arr[0].base;
            int j = 1;
            while (j < n && arr[j].time < arr[0].time) {
                j++;
            }
            User tmp = arr[0];
            if (j - 1 >= 0) {
                System.arraycopy(arr, 1, arr, 0, j - 1);
            }
            arr[j - 1] = tmp;
        }
    }
}
