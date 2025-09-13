package com.sk.twentyfive.project1.recursive;

import java.util.Arrays;

// USE lib to partition - NOT OPTIMIZED
public class QuickSortR {

    static int[] quickSortR(int[] a) {
        if (a.length < 2) {
             if (a.length == 1) System.out.println("Base case, a: " + a[0]);
            return a;
        }else {
            int pivot = a[a.length/2];
            System.out.println("pivot " + pivot);
            int[] less = Arrays.stream(a).filter(x -> x < pivot).toArray();
            int[] more = Arrays.stream(a).filter(x -> x > pivot).toArray();

            System.out.print("less: ");
            printSubArray(less);
            System.out.print("more: ");
            printSubArray(more);

            return combineArry(quickSortR(less), pivot, quickSortR(more));
        }
    }

    private static void printSubArray(int[] arrayX) {
        Arrays.stream(arrayX).forEach(x -> System.out.print(x + ","));
        System.out.println();
    }

    private static int[] combineArry(int[] less, int pivot, int[] more) {
        int newLen = less.length+ more.length + 1;
        System.out.println("newLen " + newLen + " :less.length:"
                + less.length + " :more.length:" + more.length);

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
                {3,2,1,4,5,9,8,6,7},
                {25,20, 5,30},
                {1,2,3,4,5,6,7,8,9,10}
        };

        int[][] resultTC = {
                {2, 3,5,10},
                {5,6,7},
                {1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9},
                {5,20,25,30},
                {1,2,3,4,5,6,7,8,9,10}

        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int[] result = quickSortR(inputTC[cntr]);
            if (Arrays.equals(result, resultTC[cntr])) {
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
