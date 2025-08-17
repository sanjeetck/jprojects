package com.sk.twentyfive.project1.recursive;

public class SumRecursive {

    static int sumRecursive(int[] a, int startIndex, int endIndex) {
        if (a.length < 1)
            return 0;
        if (( endIndex - startIndex) <= 1) {
          //  System.out.println("Base case " + " a: " + a[startIndex]);
            return a[startIndex];
        }else {
            System.out.println("Calling recursively with startIndex : " + (startIndex+1) + " and endIndex: " + endIndex);
            int sumTemp = a[startIndex] + sumRecursive(a, startIndex+1, endIndex);
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
               5,
                13,
              55,
               15,
               80
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = sumRecursive(inputTC[cntr], 0, inputTC[cntr].length);
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
