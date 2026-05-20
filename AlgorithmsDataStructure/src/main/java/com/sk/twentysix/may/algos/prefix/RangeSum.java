package com.sk.twentysix.may.algos.prefix;

public class RangeSum {

    static int rangeSum(int[] prefixSum, int[] range) {
        System.out.println();
        int rangeSum = prefixSum[range[1]] - prefixSum[range[0]-1];
        System.out.println("Range sum for range " + range[0] +"," + range[1] + " is : " + rangeSum);
        return rangeSum;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {1,2,3,4,5}
        };

        int[][] inputTC2 = {
                {1,3},
                {2,4}
        };

        int[] resultTC = {
                9,
                12
        };

        int[] prefixSum = PrefixSum.prefixSum(inputTC[0]);
        int totalCases = inputTC2.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC2.length; cntr++) {
            int result = rangeSum(prefixSum, inputTC2[cntr]);
            if (result == resultTC[cntr]) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed :(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed: " + (totalCases - passedCases) + " out of " + totalCases);
        }

    }
}
