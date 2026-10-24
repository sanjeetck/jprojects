package com.sk.algos.ds.newseries.algos.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaxVovelInSubString {

    public static Set<Character> vowels = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    public static int maxVowels(String s, int k) {
        int len = s.length();
        if (s == null ||  len == 0 || k > len) return -1;

        int count = 0;

        for (int i=0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) count++;
        }

        int wCount = count;
        System.out.println("Initial Substring : " + s.substring(0, k));
        System.out.println("Initial count : " + count);

        for (int i=1; i <= s.length()-k; i++) {
            System.out.println("Substring: " + s.substring(i, i+k));

            char ch = s.charAt(i-1);
            System.out.println("1 s.charAt(i-1) : " + ch);
            if (vowels.contains(ch)) {
                System.out.println("Subtract for ch: " + ch);
                count--;
            }

            ch = s.charAt(i+k-1);
            System.out.println("2 ss.charAt(i+k-1) : " + ch);
            if (vowels.contains(ch)) {
                System.out.println("add for ch: " + ch);
                count++;
            }


            wCount = Math.max(wCount, count);
            System.out.println("wCount : " + wCount);
        }
        return wCount;
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
