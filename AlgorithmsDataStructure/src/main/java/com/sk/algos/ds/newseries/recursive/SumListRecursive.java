package com.sk.algos.ds.newseries.recursive;

public class SumListRecursive {

    static int sumListRecurive(int[] a, int startIndex, int endIndex) {
        if (a.length < 1)
            return 0;
        if (( endIndex - startIndex) <= 1) {
            return 1;
        }else {
            System.out.println("Calling recursively with startIndex : " + (startIndex+1) + " and endIndex: " + endIndex);
            int sumTemp = 1 + sumListRecurive(a, startIndex+1, endIndex);
            System.out.println("sumTemp : " + sumTemp );
            return sumTemp;
        }
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {},
                {5},
                {7,6},
                {5, 6 ,7, 8, 9, 1, 2, 3, 4,10},
               {1, 2, 3, 4, 5},
               {30, 5, 20, 25}
        };

        int[] resultTC = {
                0,
               1,
                2,
              10,
               5,
               4
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = sumListRecurive(inputTC[cntr], 0, inputTC[cntr].length);
            if (result  == resultTC[cntr]) {
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
