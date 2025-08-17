package com.sk.twentyfive.project1.recursive;

public class BinarySearchResursive {

    static boolean binarySearch(int[] a, int startIndex, int endIndex, int number) {
        if (( endIndex - startIndex) <= 1) {
            return a[startIndex] == number;
        }else {
            boolean result = false;
            int mid = (endIndex + startIndex)/2;
            if (number < a[mid]) {
                System.out.println("Calling recursively with startIndex : " + (startIndex+1) + " and endIndex: " + endIndex);
                result =  binarySearch(a, startIndex, mid-1, number);
            }else {
                System.out.println("Calling recursively with startIndex : " + (startIndex+1) + " and endIndex: " + endIndex);
                result = binarySearch(a, mid, endIndex, number);
            }
            return result;
        }
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {5},
                {6,7},
                {6,7},
                {1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9,10},
               {1, 2, 3, 4, 5},
               {5,20, 25,30}
        };

        int[] inputTC2 = {
                5,
                7,
                6,
                6,
                9,
                9,
                80
        };

        boolean[] resultTC = {
                true,
               true,
                true,
                true,
                true,
              false,
               false
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            boolean result = binarySearch(inputTC[cntr], 0, inputTC[cntr].length, inputTC2[cntr]);
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
