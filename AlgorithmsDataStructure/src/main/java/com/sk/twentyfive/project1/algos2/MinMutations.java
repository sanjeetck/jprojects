package com.sk.twentyfive.project1.algos2;

import java.util.*;

public class MinMutations {

    static String validChars = "ACGT";
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> dups = new HashSet<>();
        boolean valid = validate(startGene, endGene, bank);
        if (!valid) {
            return -1;
        };

        q.offer(startGene);
        dups.add(startGene);

        int mutationSteps = 0;
        int level = 0;
        int maxLevel = startGene.length();
        while (level <= maxLevel) {
            List<String> mutationsAtLevel = new ArrayList<>();
            while (!q.isEmpty()) {
                String element = q.poll();
                System.out.println("element Polled: " + element);
                if (element.equals(endGene)) {
                    System.out.println("mutationSteps: " + mutationSteps);
                    return mutationSteps;
                }
                mutationsAtLevel.addAll(findMutationsAtNextLevel(element, bank));
            }
            mutationSteps++;
            level++;
            addToQueue(q, dups, mutationsAtLevel);

            System.out.println("Index level : " + level + " ::MutationSteps : " + mutationSteps);
            System.out.print("Queue: ");
            Arrays.stream(q.toArray()).forEach( e  -> System.out.print(e + ","));
            System.out.println("");
        }

        return -1;
    }

    private static void addToQueue(Queue<String> q, Set<String> dups,  List<String> mutationsAtLevel) {
        if (!mutationsAtLevel.isEmpty()) {
            mutationsAtLevel.stream().forEach(newElement -> {
                if (!dups.contains(newElement)) {
                    System.out.println("New Element added to q: " + newElement);
                    q.offer(newElement);
                    dups.add(newElement);
                }
            });
        }
    }

    private static List<String> findMutationsAtNextLevel(String element, String[] bank) {
        List<String> mutations = new ArrayList<>();
        Arrays.stream(bank).forEach(bankElement -> {
            int diffLevel = 0;
            for (int i = 0; i < element.length(); i++) {
                if (element.charAt(i) != bankElement.charAt(i)) {
                    diffLevel++;
                    if (diffLevel > 1) break;
                }
            }
            if (diffLevel == 1) mutations.add(bankElement);

        });

        System.out.print("Mutation for element: "+ element + ":: ");
        mutations.forEach( (e) -> {
            System.out.print("Element : " + e);
        } );
        System.out.println("");

        return mutations;
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
