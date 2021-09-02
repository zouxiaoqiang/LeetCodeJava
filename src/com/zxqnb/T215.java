package com.zxqnb;

public class T215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {
        int pivot = partition(nums, l, r);
        if (pivot > k) {
            return findKthLargest(nums, l, pivot - 1, k);
        } else if (pivot < k) {
            return findKthLargest(nums, pivot + 1, r, k);
        } else {
            return nums[pivot];
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] < pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = pivot;
        return l;
    }

    private int partition1(int[] nums, int l, int r) {
        int x = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest1(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapSize--;
            sink(nums, heapSize, 0);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            sink(nums, heapSize, i);
        }
    }

    private void sink(int[] nums, int heapSize, int i) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, largest, i);
            sink(nums, heapSize, largest);
        }
    }

}
