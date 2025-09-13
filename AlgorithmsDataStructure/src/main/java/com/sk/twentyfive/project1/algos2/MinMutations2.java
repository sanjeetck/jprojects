package com.sk.twentyfive.project1.algos2;

import java.util.*;

public class MinMutations2 {
    static String validChars = "ACGT";
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> q = new ArrayDeque<>();
        HashMap<String, Integer> mCount = new HashMap<>();
        for (String s: bank) mCount.put(s, -1);
        mCount.put(startGene,0);

        boolean valid = validate(startGene, endGene, bank);
        if (!valid) {
            return -1;
        };

        q.addLast(startGene);

        while (!q.isEmpty()) {
            String element = q.poll();
            System.out.println("element Polled: " + element);
            if (element.compareTo(endGene) == 0) {
                System.out.println("Count: " + mCount.get(element));
                return mCount.get(element);
            }
            for(String str:bank) {
                if (mCount.get(str) == -1 && check(str, element) ) {
                    mCount.put(str, mCount.get(element)+1);
                    q.addLast(str);
                }
            }
            System.out.println("mCount: ");
            mCount.forEach( (key, value) -> {System.out.println("Key:" + key + "::Value:" + value  );});

            System.out.print("Queue: ");
            Arrays.stream(q.toArray()).forEach( e  -> System.out.print(e + ","));
            System.out.println("");
        }
        return -1;
    }

    private static boolean check(String str, String element) {
        char[] s = str.toCharArray();
        char[] curr = element.toCharArray();

        int diff = 0;
        for (int i=0; i < 8; i++) {
            if (s[i] != curr[i]) diff++;
            if (diff > 1) return false;
        }
        return true;
    }


    private static boolean validate (String startGene, String endGene, String[] bank) {
        if (startGene.length() != 8 || !validCharInString(startGene)) {
            return false;
        }

        if (endGene.length() != 8 || !validCharInString(endGene)) {
            return false;
        }

        for (int i = 0; i < bank.length; i++) {
            String element = bank[i];
            if (element.length() != 8 || !validCharInString(element) ){
                return false;
            }
        }
        System.out.println("Valid : " + true);
        return true;
    }

    private static boolean validCharInString(String str) {
        for (int i=0; i < str.length(); i++) {
            if (validChars.indexOf(str.charAt(i)) == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputTC = {
                "AACCGGTT",
                "AACCGGTT",
                "AACCGGTT",
                "AACCTTGG",
                "AAAAAAAA"
        };

        String[] inputTC2 = {
                "AACCGGTA",
                "AAACGGTA",
                "AACCGCTA",
                "AATTCCGG",
                "CCCCCCCC"
        };

        String[][] inputTC3 = {
                {"AACCGGTA"},
                {"AACCGGTA","AACCGCTA","AAACGGTA"},
                {"AACCGGTA","AACCGCTA","AAACGGTA"},
                {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"},
                {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"}
        };

        int[] resultTC = {
                1,
                2,
                2,
                -1,
                8
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = minMutation(inputTC[cntr], inputTC2[cntr], inputTC3[cntr]);
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
