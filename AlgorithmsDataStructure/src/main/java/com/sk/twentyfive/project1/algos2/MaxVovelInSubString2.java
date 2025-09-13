package com.sk.twentyfive.project1.algos2;

public class MaxVovelInSubString2 {


    public static int maxVowels2(String s, int k) {
        String vowels = "aeiou";
        if (s == null || s.length() == 0) return -1;
        if (k > s.length()) return -1;

        int sum = 0;

        for (int i=0; i < k; i++) {
            System.out.println("s.charAt(i) : " + s.charAt(i));
            if (vowels.indexOf(s.charAt(i)) != -1) sum++;
        }

        int windowSum = sum;
        System.out.println("Initial Substring : " + s.substring(0, k));
        System.out.println("Initial count : " + sum);

        for (int cntr=1; cntr <= s.length()-k; cntr++) {
            System.out.println("Substring: " + s.substring(cntr, cntr+k));

            System.out.println("1 s.substring(cntr-1, cntr) : " + s.substring(cntr-1, cntr));
            if (vowels.indexOf(s.charAt(cntr-1)) != -1) {
                System.out.println("Subtract for : " + s.charAt(cntr-1));
                sum--;
            }

            System.out.println("2 s.substring(cntr+k-1, cntr+k) : " + s.substring(cntr+k-1, cntr+k));
            if (vowels.indexOf(s.charAt(cntr+k-1)) != -1) {
                System.out.println("add for : " + s.charAt(cntr+k-1));
                sum++;
            }


            windowSum = Math.max(windowSum, sum);
            System.out.println(" windowSum : " + windowSum);
        }
        return windowSum;
    }

    public static void main(String[] args) {
        String[] inputTC = {
                "abciiidef",
                "weallloveyou"
        };

        int[] inputTC2 = {
               3,
                7
        };

        int[] resultTC = {
                3,
                4
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = maxVowels2(inputTC[cntr], inputTC2[cntr]);
            if (result  == resultTC[cntr]) {
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
