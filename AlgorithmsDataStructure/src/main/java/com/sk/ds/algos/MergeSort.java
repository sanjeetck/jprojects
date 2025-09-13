package com.sk.ds.algos;

import java.util.Arrays;

public class MergeSort {
    static int[] aux;

    static void mergeSort(int[] nums, int lo, int hi) {

        System.out.printf("Initial Sort Array: %s,  lo:%d, hi: %d%n", Arrays.toString(nums), lo, hi);
        sort(nums,  lo,  hi);
        System.out.printf("Last Sort Array: %s,  lo:%d, hi: %d%n", Arrays.toString(nums), lo, hi);

    }

    static void merge(int[] nums, int lo, int mid, int hi) {
        System.out.printf("Initial Merge  lo:%d,  mid:%d, hi: %d%n", lo, mid, hi);
        int i = lo, j = mid+1;

        System.out.printf("Before Aux  %s%n", Arrays.toString(aux));
        for (int k=lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        System.out.printf("After Aux  %s%n", Arrays.toString(aux));

        for (int k=lo; k <= hi; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[j] < aux[i]) nums[k] = aux[j++];
            else nums[k] = aux[i++];
        }

      //   System.out.printf("After Merge  %s%n", Arrays.toString(nums));
    }

    static void sort(int[] nums, int lo, int hi) {

        if (hi <= lo) return;

        int mid = lo + (hi - lo)/2;
        System.out.printf("Sort  lo:%d, mid:%d, hi: %d%n", lo, mid, hi);
        sort(nums,lo, mid);
        sort(nums, mid+1, hi);

        merge(nums,lo,mid,hi);

    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {5, 6 ,9, 8, 7,13, 12, 15, 10, 2, 3, 4, 1, 12,11},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {22, 12, 31, 51, 27, 16, 34, 49}
        };
        int[] input2TC = {
                15,
                9,
                8
        };
        int[][] resultTC = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 16, 22, 27, 31, 34, 49, 51}
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            aux = new int[inputTC[cntr].length];
            mergeSort(inputTC[cntr],0, input2TC[cntr]-1);
            if (Arrays.equals(inputTC[cntr], resultTC[cntr])) {
                passedCases++;
            }else {
                System.out.printf("Failed case :(%d) %n", (cntr+1));
            }
        }

        if (totalCases == passedCases) {
            System.out.printf("Total cases passed:( %d / %d )%n", passedCases, totalCases);
        } else {
            System.out.printf("Number of cases failed : (%d out of %d)%n",(totalCases - passedCases), totalCases);
        }
    }

}
