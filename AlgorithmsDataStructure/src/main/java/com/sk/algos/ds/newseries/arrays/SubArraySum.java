package com.sk.algos.ds.newseries.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 1 && nums[0] != k)
            return 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int cSum = 0;
        int results = 0;
        for (int num : nums) {
            cSum += num;

            results += prefixSum.getOrDefault(cSum - k, 0);

            prefixSum.put(cSum, prefixSum.getOrDefault(cSum, 0) + 1);
        }

        return results;
    }
    public static void main(String[] args) {

        int[][] inputTC1 = {
                {1,1,1},
               {1,2,3},
               {-1,-1,1},
                {1,-1,0}
        };

        int[] inputTC2 = {
               2,
               3,
                0,
                0
        };

        int[] resultTC1 = {
               2,
                2,
                1,
                3
        };

        int totalCases = inputTC1.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = subarraySum(inputTC1[cntr], inputTC2[cntr]);

            if (result == resultTC1[cntr]) {
                passedCases++;
            }else {
                System.out.println("Failed TC : " + (cntr+1));
            }

        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
