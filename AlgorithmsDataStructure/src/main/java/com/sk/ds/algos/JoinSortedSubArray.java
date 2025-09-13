package com.sk.ds.algos;

import java.util.Arrays;

public class JoinSortedSubArray {

    static int[] joinSortedSubArray(int[] a, int lo, int mid, int hi) {
        System.out.println("values: " + lo + ":" + mid + ":" + hi);
        int aux[] = new int[hi];
        int i = lo; int j = mid;

        for (int k=lo; k < hi; k++) {
            aux[k] = a[k];
        }

        for(int k = lo; k < hi; k++) {
            if (i >= mid)            { aux[k] = a[j++]; }
            else if (j >= hi)         { aux[k] = a[i++]; }
            else if (a[i] <= a[j])   { aux[k] = a[i++]; }
            else if (a[j] <= a[i])   { aux[k] = a[j++]; }
        }

        System.out.println("values: ");
        for (int k=lo; k < hi; k++) {
            System.out.print(aux[k] + " ");
        }
        System.out.println(" ");
        return aux;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {5, 6 ,7, 8, 9, 1, 2, 3, 4, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 22, 31, 51, 16, 27, 34, 49}
        };
        int[] input2TC = {
                10,
                9,
                8
        };
        int[][] resultTC = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 16, 22, 27, 31, 34, 49, 51}
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int[] result = joinSortedSubArray(inputTC[cntr],0, (input2TC[cntr]/2), input2TC[cntr]);
            if (Arrays.equals(result, resultTC[cntr])) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
        }
    }

}
