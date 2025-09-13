package com.sk.twentyfive.project1.heap;

import java.util.Arrays;



public class BinaryHeap {
    static int N;
    static int[] heap;
    static int[] binaryHeap(int[] nums) {
        int cntr = 0;
        N=0;
        heap = new int[nums.length+1];
        while (cntr < nums.length) {
            insert(nums[cntr++]);
        }
        return heap;
    }

   private static void insert(int v) {
       heap[++N] = v;
       swim(N);
    }

    private static void swim(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            swap(heap,k/2, k);
            k = k/2;
        }
    }

    private static void swap(int[] nums, int parent, int child) {
        int temp = nums[parent];
        nums[parent] = nums[child];
        nums[child] = temp;
    }

    public static void main(String[] args) {
        int[][] inputTC = {
                {10, 3, 2,5},
                {6,7, 5},
                {3,2,5,4,1,9,8,6,7,10},
                {1,2,3,4,5,6,7,8,9,10}
        };

        int[][] resultTC = {
               {0,10, 5, 2, 3},
               {0,7,6,5},
                {0,10,9,8,6,7,3,5,2,4,1},
                {0, 10, 9, 6, 7, 8, 2, 5, 1, 4, 3}

        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int[] result = binaryHeap(inputTC[cntr]);
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
