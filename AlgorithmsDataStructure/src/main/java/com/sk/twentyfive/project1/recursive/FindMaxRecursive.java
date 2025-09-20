package com.sk.twentyfive.project1.recursive;

public class FindMaxRecursive {

    static int maxRecurive(int[] a, int startIndex, int endIndex) {
        if (a.length < 1)
            return 0;
        if (( endIndex - startIndex) <= 1) {
          //  System.out.println("Base case " + " a: " + a[startIndex]);
            return a[startIndex];
        }else {
            System.out.println("Calling recursively with startIndex : " + (startIndex+1) + " and endIndex: " + endIndex);
            int maxNumber = Integer.max( a[startIndex] , maxRecurive(a, startIndex+1, endIndex));
            System.out.println("maxNumber : " + maxNumber );
            return maxNumber;
        }
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {},
                {5},
                {7,6},
                {5, 6 ,7, 8, 9, 1, 2, 3, 4},
               {1, 2, 3, 4, 5},
               {30, 5, 20, 25}
        };

        int[] resultTC = {
                0,
               5,
                7,
              9,
               5,
               30
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = maxRecurive(inputTC[cntr], 0, inputTC[cntr].length);
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
