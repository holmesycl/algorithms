package com.holmesycl.algorithms.sort;

public class MergeBU extends Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz * 2){
            for(int lo = 0; lo < N - sz; lo += sz * 2){
                merge(a, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, N - 1));
            }
        }
    }

}
