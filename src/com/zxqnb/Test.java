package com.zxqnb;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    /**
     * 广义猫脸变换
     *
     * @param origin 原图
     * @param dest   变换后的图
     * @param SIZE   图像宽度和高度
     * @param count  变换次数
     */
    public void arnold(int[] origin, int[] dest, int SIZE, int count, int a, int b) {
        final int ab_plus_1 = a * b + 1;
        int oldY, oldX, newY, newX;
        while (count > 0) {
            for (int index = 0; index < origin.length; index++) {
                oldX = index % SIZE;
                oldY = index / SIZE;
                newX = (oldX + a * oldY) % SIZE;
                newY = (b * oldX + ab_plus_1 * oldY) % SIZE;
                dest[newY * SIZE + newX] = origin[index];
            }
            count--;
            origin = Arrays.copyOf(dest, dest.length);
        }
    }

    /**
     * 广义猫脸逆变换
     *
     * @param origin 原图
     * @param dest   变换后的图
     * @param SIZE   图像宽度和高度
     * @param count  变换次数
     */
    public void inverseArnold(int[] origin, int[] dest, int SIZE, int count, int a, int b) {
        final int ab_plus_1 = a * b + 1;
        int oldY, oldX, newY, newX;
        while (count > 0) {
            for (int index = 0; index < origin.length; index++) {
                oldX = index % SIZE;
                oldY = index / SIZE;
                newX = (ab_plus_1 * oldX - a * oldY) % SIZE;
                newY = (oldY - b * oldX) % SIZE;
                dest[newY * SIZE + newX] = origin[index];
            }
            count--;
            origin = Arrays.copyOf(dest, dest.length);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[36];
        for (int i = 0; i < 36; i++) {
            a[i] = i;
        }
        Test t = new Test();
        int[] b = new int[36];
        t.arnold(a, b, 6, 1, 3, 5);
        System.out.println(a);
        t.inverseArnold(a, b, 6, 1, 3, 5);
        System.out.println(a);
    }
}