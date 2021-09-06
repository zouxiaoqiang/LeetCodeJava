package com.zxqnb;

public class MinHeap {
    private int[] data;

    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = (data.length / 2) - 1; i >= 0; i--) {
            sink(i);
        }
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private void sink(int i) {
        int l = (i + 1) << 2, r = l + 1;
        int smallest = i;
        if (r < data.length && data[r] < data[smallest]) {
            smallest = r;
        }
        if (l < data.length && data[l] < data[smallest]) {
            smallest = l;
        }
        if (smallest != i) {
            swap(smallest, i);
            sink(smallest);
        }
    }
}
