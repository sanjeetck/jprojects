package com.sk.twentyfive.project1.heap;

import java.util.Arrays;

public class BinaryHeap2 {
    static int N;
    static int[] heap;
    static int[] binaryHeap(int[] nums, int extractTop, int[] result1) {
        int cntr = 0;
        N=0;
        heap = new int[nums.length+1];
        while (cntr < nums.length) {
            insert(nums[cntr++]);
        }

        System.out.printf("Heap: %s%n", Arrays.toString(heap));
        if (Arrays.equals(heap, result1)) {
            System.out.println("After Insert Heap passed");
        }

        cntr = 0;
        while (cntr++ < extractTop) {
            extractTop();
        }
        System.out.printf("Heap after extraction: %s%n", Arrays.toString(heap));
        return heap;
    }

    private static void extractTop() {
        System.out.printf("Extracted top: %d%n", heap[1]);
        swap(1,N); heap[N--] = 0;
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
        if (heap.length < j+1) return false;
        return  heap[j] < heap[j + 1];
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

        int[] inputTC2 = {
                1,
                0,
                3,
                4
        };

        int[][] resultTC = {
               {0, 5, 3, 2, 0},
               {0,7,6,5},
                {0,10,9,8,6,7,3,5,2,4,1},
                {0, 10, 9, 6, 7, 8, 2, 5, 1, 4, 3}

        };

        int[][] result2TC = {
                  {0, 5, 3, 2, 0},
                  {0,7,6,5},
                   {0, 7, 6, 5, 2, 1, 3, 4, 0, 0, 0},
                {0, 6, 4, 5, 1, 3, 2, 0, 0, 0, 0}

        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int[] result = binaryHeap(inputTC[cntr], inputTC2[cntr], resultTC[cntr]);
            if (Arrays.equals(result, result2TC[cntr])) {
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
