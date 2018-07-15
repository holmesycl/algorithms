package com.holmesycl.algorithms.sort;

import java.util.Random;

public class SortCompare {

    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")){
            Insertion.sort(a);
        }else if(alg.equals("Selection")){
            Selection.sort(a);
        }else if(alg.equals("Shell")){
            Shell.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        Random random = new Random();
        for (int t = 0; t < T; t++){
            for (int i = 0; i < N; i++){
                a[i] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Shell";
        int N = 1000000;
        int T = 20;
        //double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        //System.out.println(alg1 + " : " + t1);
        System.out.println(alg2 + " : " + t2);
    }

}
