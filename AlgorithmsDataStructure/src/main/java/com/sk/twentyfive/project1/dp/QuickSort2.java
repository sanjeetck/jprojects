package com.sk.twentyfive.project1.dp;

import java.util.Arrays;

public class QuickSort2 {

    static void quickSort2(int[] num, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partitiion(num, lo, hi);
        quickSort2(num, lo, pivot-1);
        quickSort2(num,pivot+1, hi);
    }

    private static int partitiion(int[] num, int lo, int hi) {
        int i = lo, j = hi+1;
        int pivot = num[lo];
        System.out.printf("Before partition  %s, i:%d, j:%d, lo:%d, hi:%d %n", Arrays.toString(num), i,j,lo,hi);

        while (true) {
            while (num[++i] < pivot) if (i >= hi) break;
            while (num[--j] > pivot) if (j <= lo) break;

            if (j <= i) break;

            System.out.println("exchange i  j");
            exch(num, i,j);
        }
        System.out.println("exchange lo j");
        exch(num, lo,j);
        System.out.printf("After partition  %s, i:%d, j:%d, lo:%d  hi:%d%n", Arrays.toString(num), i,j,lo,hi);
        return j;
    }

    private static void exch(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
               // {10, 5,2, 3},
             //   {6,7, 5},
                {3,2,5,4,1,9,8,6,7,10},
             //   {3,2,5,4,1,9,8,6,7},
                {25,20, 5,30}
        };

        int[][] resultTC = {
            //    {2, 3,5,10},
             //   {5,6,7},
                {1,2,3,4,5,6,7,8,9,10},
             //   {1,2,3,4,5,6,7,8,9},
                {5,20,25,30}

        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            quickSort2(inputTC[cntr], 0, inputTC[cntr].length-1);
            if (Arrays.equals(inputTC[cntr], resultTC[cntr])) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
