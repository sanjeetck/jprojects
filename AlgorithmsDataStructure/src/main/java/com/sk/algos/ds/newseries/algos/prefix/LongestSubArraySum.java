package com.sk.algos.ds.newseries.algos.prefix;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static int longestSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        int maxLen = 0;
        int len;

        for (int i=0; i < nums.length; i++) {
            sum += nums[i];

            int reqP = sum - k;

            int oldIdx = map.getOrDefault(reqP, -2);
            //System.out.println("sum: " + sum + " oldIdx:" + oldIdx);
            if (oldIdx != -2) { // existing
                len = i - oldIdx;

                if (len > maxLen) {
                    maxLen = len;
                }
            }
            map.putIfAbsent(sum -k, i);
            //System.out.println("len: " + len + " maxLen:" + maxLen);
        }
        return maxLen;
    }

    public static int longestSubarraySum2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        int maxLen = 0;
        int len;

        for (int i=0; i < nums.length; i++) {
            sum += nums[i];

            int reqP = sum - k;

            if (map.containsKey(reqP)) {
                len = i - map.get(reqP);

                if (len > maxLen) {
                    maxLen = len;
                }
            }
            map.putIfAbsent(reqP, i);
            //System.out.println("sum: " + sum + " oldIdx:" + oldIdx);
            //System.out.println("len: " + len + " maxLen:" + maxLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {

        int[][] inputTC1 = {
                {10, 5, 2, 7, 1, -10},
                {-5, 8, -14, 2, 4, 12},
                {10, -10, 20, 30}
        };

        int[] inputTC2 = {
                15,
                -5,
                5
        };

        int[] resultTC1 = {
                6,
                5,
                0
        };

        int totalCases = inputTC1.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = longestSubarraySum2(inputTC1[cntr], inputTC2[cntr]);

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
