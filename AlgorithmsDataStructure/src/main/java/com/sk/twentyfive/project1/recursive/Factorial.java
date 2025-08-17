package com.sk.twentyfive.project1.recursive;

public class Factorial {

    static int factorial(int number) {
        if ( number <= 2) {
          //  System.out.println("Base case " + " a: " + a[startIndex]);
            return number;
        }else {
            System.out.println("Calling recursively with number : " + (number-1));
            int factorial = number *  factorial(number-1);
            System.out.println("factorial : " + factorial );
            return factorial;
        }
    }

    public static void main(String[] args) {

        int[] inputTC = {
                1,
                5,
                4,
                10,
                2,
                8
        };

        int[] resultTC = {
                1,
               120,
                24,
              3628800,
               2,
               40320
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = factorial(inputTC[cntr]);
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
