package com.sk.ds.algos;

import java.util.Arrays;

// FAILS
public class MergeSortR {
    static int aux[] ;
    static void MergeSortR(int[] a, int lo, int hi) {
        System.out.println("indices: " + lo + ":"  + ":" + hi);

        if (hi <= lo)  {
            return;
        }else {
            int mid = lo + (hi - lo) / 2;
            MergeSortR(a, lo, mid);
            MergeSortR(a, mid +1, hi);
        }
        join(a, lo, hi);
    }

    private static void join(int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        System.out.println("join-indices: " + lo + ":" + mid + ":" + hi);

        int i = lo; int j = mid+1;

        for (int k=lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++) {
            if (i > mid)            { a[k] = aux[j++]; }
            else if (j > hi)        { a[k] = aux[i++]; }
            else if (aux[j] < aux[i])   { a[k] = aux[j++]; }
            else    { a[k] = aux[i++]; }
        }

       /* System.out.println("values: ");
        for (int k=lo; k <= hi; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println(" ");*/
    }

    public static void main(String[] args) {
        int[][] inputJoinTC = {
                {5,6,7,8,9, 1, 2, 3, 4, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 22, 31, 34, 16, 27, 49, 51}
        };
        int[] input2JoinTC = {
                10,
                9,
                8
        };
        int[][] resultJoinTC = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 16, 22, 27, 31, 34, 49, 51}
        };

        int[][] inputTC = {
                {5, 6 ,9, 8, 7,13, 12, 15, 10, 2, 3, 4, 1, 12,11},
               {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {12, 22, 31, 34, 51, 16, 27, 49}
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

        boolean testJoin = false;

        if (!testJoin) {
            int totalCases = inputTC.length;
            int passedCases = 0;
            for (int cntr = 0; cntr < inputTC.length; cntr++) {
                aux = new int[input2TC[cntr]];
                MergeSortR(inputTC[cntr], 0, input2TC[cntr] - 1);
                if (Arrays.equals(inputTC[cntr], resultTC[cntr])) {
                    passedCases++;
                } else {
                    System.out.println("Failed case :" + (cntr + 1));
                }

                if (totalCases == passedCases) {
                    System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
                } else {
                    System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
                }
            }
        }else {
            int totalCases = inputJoinTC.length;
            int passedCases = 0;
            for (int cntr = 0; cntr < inputJoinTC.length; cntr++) {
                aux = new int[input2JoinTC[cntr]];
                join(inputJoinTC[cntr], 0, input2JoinTC[cntr] - 1);
                if (Arrays.equals(inputJoinTC[cntr], resultJoinTC[cntr])) {
                    passedCases++;
                } else {
                    System.out.println("Failed case :" + (cntr + 1));
                }
            }

            if (totalCases == passedCases) {
                System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
            } else {
                System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
            }
        }


    }

}
