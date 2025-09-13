package com.sk.twentyfive.project1.heap;

import java.util.Arrays;

public class HeapSort {
    static int N;
    static int[] heap;
    static int[] heapSort(int[] nums) {
       int cntr = 0;
       N=0;
       heap = new int[nums.length+1];
       for (int i=0; i < nums.length; i++) {
           heap[++N] = nums[i];
       }

       System.out.printf("Heap: %s, N:%d %n", Arrays.toString(heap), N);

       for (int k=N/2; k >= 1; k--) {
           sink(k);
           //System.out.printf("Heap after sink: %s, N:%d %n", Arrays.toString(heap), N);
       }
       System.out.printf("Heap after sink final: %s, N:%d %n", Arrays.toString(heap), N);

       while (N >1) {
           extractTop();
       }

        System.out.printf("Heap: %s%n", Arrays.toString(heap));
        return heap;
    }

    private static void extractTop() {
        System.out.printf("Extracted top: %d%n", heap[1]);
        swap(1,N--);
        // heap[N--] = 0;
        sink(1);
    }

    private static void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && compareChilds(j)) j++;
            if (!(heap[k] < heap[j])) break;
            swap(k,j);
            k = j;
        }
    }

    private static boolean compareChilds(int j) {
        if (N < (j+1)) return false;
        return heap[j] < heap[j + 1];
    }

    private static void insert(int v) {
       heap[++N] = v;
       swim(N);
    }

    private static void swim(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            swap(k/2, k);
            k = k/2;
        }
    }

    private static void swap(int parent, int child) {
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    public static void main(String[] args) {
        int[][] inputTC = {
                {10, 3, 2,5},
                {6,7, 5},
                {3,2,5,4,1,9,8,6,7,10},
                {1,2,3,4,5,6,7,8,9,10}
        };

        int[][] resultTC = {
               {0, 2, 3,5, 10},
               {0,5,6,7},
                {0,1,2,3,4,5,6,7,8,9,10},
                {0, 1,2,3,4,5,6,7,8,9,10}

        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int[] result = heapSort(inputTC[cntr]);
            if (Arrays.equals(result, resultTC[cntr])) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + (cntr + 1));
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }

}
