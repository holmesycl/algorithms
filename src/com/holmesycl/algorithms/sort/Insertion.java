package com.holmesycl.algorithms.sort;

public class Insertion extends Sort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"1", "3", "2", "9", "4", "8"};
        sort(a);
        assert isSorted(a);
        show(a); // 1 2 3 4 8 9
    }

}
