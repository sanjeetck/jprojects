package com.sk.twentyfive.project1.algos2;

import java.util.HashMap;
import java.util.Map;

public class MaxVovelInSubString {

    public static Map<String, String> vowels = new HashMap<String, String>() {{
        put("a", "a");
        put("e", "e");
        put("i", "i");
        put("o", "o");
        put("u", "u");}};

    public static int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) return -1;
        if (k > s.length()) return -1;

        int sum = 0;

        for (int i=0; i < k; i++) {
            if (vowels.get(s.substring(i, i+1)) != null) sum++;
        }

        int windowSum = sum;
        System.out.println("Initial Substring : " + s.substring(0, k));
        System.out.println("Initial count : " + sum);

        for (int cntr=1; cntr <= s.length()-k; cntr++) {
            System.out.println("Substring: " + s.substring(cntr, cntr+k));

            System.out.println("1 s.substring(cntr-1, cntr) : " + s.substring(cntr-1, cntr));
            if (vowels.get(s.substring(cntr-1, cntr)) != null) {
                System.out.println("Subtract for : " + s.substring(cntr-1, cntr));
                sum--;
            }

            System.out.println("2 s.substring(cntr+k-1, cntr+k) : " + s.substring(cntr+k-1, cntr+k));
            if (vowels.get(s.substring(cntr+k-1, cntr+k)) != null) {
                System.out.println("add for : " + s.substring(cntr+k-1, cntr+k));
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
            int result = maxVowels(inputTC[cntr], inputTC2[cntr]);
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
