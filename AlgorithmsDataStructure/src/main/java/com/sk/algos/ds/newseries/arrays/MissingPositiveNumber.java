package com.sk.algos.ds.newseries.arrays;

public class MissingPositiveNumber {
    public int missingPositiveNumber(int[] nums) {
        int n = nums.length;

        for (int i=0; i<n;i++) {
            while (nums[i] >= 1 && nums[i] <= n &&
                    nums[nums[i] - 1] != nums[i]) {
                int targetIdx = nums[i] - 1;

                int temp = nums[targetIdx];
                nums[targetIdx] = nums[i];
                nums[i]  = temp;
            }
        }
        for (int i=0; i<n;i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {

        int[][] inputTC1 = {
                {1,2,0},
                {3,4,-1,1},
                {7,8,9,11,12}

        };

        int[] resultTC1 = {
                3,
                2,
                1
        };

        int totalCases = inputTC1.length;
        int passedCases = 0;
        MissingPositiveNumber missingNumObj = new MissingPositiveNumber();
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = missingNumObj.missingPositiveNumber(inputTC1[cntr]);
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

