package com.holmesycl.algorithms.sort;

/**
 * 选择排序
 */
public class Selection extends Sort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1..N]中最小的元素交换
            int min = i; // 最小元素索引s
            for (int j = i + 1; j < N; j++) {
                // (N-1) + (N -2) + ... + 2 + 1 ~ N^2/2次比较
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            // N次交换
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = {"1", "3", "2", "9", "4", "8"};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
