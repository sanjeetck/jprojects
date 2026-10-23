package com.sk.algos.ds.newseries.algos.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxInEveryWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k <= 0 || k > n ) {
            return new int[0];
        }

        Deque<Integer> q = new ArrayDeque<>();
        int[] result = new int[n -k + 1];

        for (int right = 0; right < n; right++) {

            while (!q.isEmpty() && q.peekFirst() <= (right - k)) {
                System.out.println("Expired: "+ q.peekFirst());
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[q.peekLast()] <= nums[right] ) {
                System.out.println("Smaller: "+ q.peekLast());
                q.pollLast();
            }

            System.out.println("Add: "+ right);
            q.offerLast(right);

            if (right >= k - 1) {
                result[right-k+1] = nums[q.peekFirst()];
                System.out.println("result: "+ result[right-k+1] + " idx:" + (right-k+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {1,3,-1,-3,5,3,6,7},
                {1},
                {1,-1},
                {7,2,4}
        };

        int[] inputTC2 = {
                3,
                1,
                1,
                2
        };

        int[][] resultTC = {
                {3,3,5,5,6,7},
                {1},
                {1,-1},
                {7,4}
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        MaxInEveryWindow obj = new MaxInEveryWindow();
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int[] result = obj.maxSlidingWindow(inputTC[cntr], inputTC2[cntr]);
            if ( Arrays.equals(result, resultTC[cntr]) ) {
                System.out.println("Case passed");
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
