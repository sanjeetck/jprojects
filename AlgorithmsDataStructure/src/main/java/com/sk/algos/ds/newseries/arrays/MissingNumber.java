package com.sk.algos.ds.newseries.arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        for (int i=0; i<n;i++) {
            while (nums[i] < n && nums[i] != i) {
                int targetIdx = nums[i];

                int temp = nums[targetIdx];
                nums[targetIdx] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i=0; i<n;i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

   /* public int missingNumberAlgebra(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return expected - actual;
    }*/
    public static void main(String[] args) {

        int[][] inputTC1 = {
                {3,0,1},
                {0,1},
                {9,6,4,2,3,5,7,0,1},
                {1,2},
                {2,1}
        };

        int[] resultTC1 = {
                2,
                2,
                8,
                0,
                0
        };

        int totalCases = inputTC1.length;
        int passedCases = 0;
        MissingNumber missingNumObj = new MissingNumber();
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = missingNumObj.missingNumber(inputTC1[cntr]);
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

