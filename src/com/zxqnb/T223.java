package com.zxqnb;

public class T223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ay2 - ay1) * (ax2 - ax1), area2 = (by2 - by1) * (bx2 - bx1);
        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1) {
            return area1 + area2;
        }
        int cover = (Math.min(ay2, by2) - Math.max(ay1, by1)) * (Math.min(ax2, bx2) - Math.max(ax1, bx1));
        return area1 + area2 - cover;
    }

    public static void main(String[] args) {
        System.out.println(new T223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
