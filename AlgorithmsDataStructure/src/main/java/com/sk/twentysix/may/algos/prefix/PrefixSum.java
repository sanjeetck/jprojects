package com.sk.twentysix.may.algos.prefix;

import java.util.Arrays;

public class PrefixSum {

    public static int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        System.out.print("Prefix Sum: " + prefixSum[0] + " ");
        for (int i=1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
            System.out.print(prefixSum[i] + " ");
        }

        return prefixSum;
    }

    public static int[] prefixSum2(int[] arr) {
        int[] prefixSum = new int[arr.length+1];
        prefixSum[0] = 0;

        System.out.print("Prefix Sum: " + prefixSum[0] + " ");
        for (int i=0; i < arr.length; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
            System.out.print(prefixSum[i+1] + " ");
        }

        return prefixSum;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {1,2,3,4,5},
                {5},
                {7,6},
                {30, 5, 20, 25}
        };

        int[][] resultTC = {
                {1,3,6,10,15},
                {5},
                {7,13},
                {30, 35, 55, 80}
        };

        int[][] resultTC2 = {
                {0, 1,3,6,10,15},
                {0, 5},
                {0, 7,13},
                {0, 30, 35, 55, 80}
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int[] result = prefixSum(inputTC[cntr]);
            if (Arrays.equals(result,resultTC[cntr])) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed prefixSum1 :(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed prefixSum1: " + (totalCases - passedCases) + " out of " + totalCases);
        }

        passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int[] result = prefixSum2(inputTC[cntr]);
            if (Arrays.equals(result,resultTC2[cntr])) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed prefixSum2 :(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed prefixSum2: " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
