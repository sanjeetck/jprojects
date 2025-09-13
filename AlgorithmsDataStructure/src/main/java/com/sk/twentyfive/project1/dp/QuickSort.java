package com.sk.twentyfive.project1.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Implement non recursive version - Randomize the pivot
public class QuickSort {

    static void quickSortR2(int[] a, int lo, int hi) {

       // List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        //Collections.shuffle(list);
      //  a = list.stream().mapToInt(i->i).toArray();
        System.out.println("SubArr: ");
        printSubArray(a);

        if (hi <= lo) return;

        int pivotIdx = partition(a,  lo, hi);
        quickSortR2(a, lo, pivotIdx-1);
        quickSortR2(a, pivotIdx+1, hi);

        return;
    }

    private static int partition(int[] a, int lo, int hi) {
        System.out.println("partition with lo:" + lo + " :hi: " + hi);
        int i = lo, j = hi+1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi)  break;
            while (v < a[--j]) if (j == lo)  break;

            if (i >= j) break;

            System.out.println("exchange i < j");
            exch(a,i,j);
        }
        System.out.println("exchange lo j");
        exch(a,lo,j);
        printSubArray(a);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printSubArray(int[] arrayX) {
        Arrays.stream(arrayX).forEach(x -> System.out.print(x + ","));
        System.out.println();
    }

    private static int[] combineArry(int[] less, int pivot, int[] more) {
        int newLen = less.length+ more.length + 1;
        System.out.println("newLen " + newLen + " :less.length:" + less.length + " :more.length:" + more.length);

        int xSorted[] = new int[newLen];

        System.arraycopy(less, 0, xSorted, 0, less.length);

        xSorted[less.length] = pivot;

        System.arraycopy(more, 0, xSorted, less.length+1, more.length);

        System.out.print("Sorted SubArray: ");
        printSubArray(xSorted);
        return xSorted;

          /* for (int i=0; i < less.length; i++) {
            xSorted[i] = less[i];
        }*/
        /*  for (int j=less.length+1,  k=0; j < newLen; j++, k++) {
            xSorted[j] = more[k];
        }*/
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {10, 5,2, 3},
                {6,7, 5},
                {3,2,5,4,1,9,8,6,7,10},
                {3,2,5,4,1,9,8,6,7},
                {25,20, 5,30}
        };

        int[][] resultTC = {
                {2, 3,5,10},
                {5,6,7},
                {1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9},
                {5,20,25,30}

        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            quickSortR2(inputTC[cntr], 0, inputTC[cntr].length-1);
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
