package com.sk.algos.ds.newseries.algos.trie;

import java.util.*;

public class TrieST2Application {
    public static void main(String[] args) {
        TrieST<Integer> trie = new TrieST<>();

        // Input data for test cases
        Map<String, Integer> inputTC = new HashMap<>();
        inputTC.put("she", 0);
        inputTC.put("sells", 1);
        inputTC.put("sea", 2);
        inputTC.put("shells", 3);
        inputTC.put("by", 4);
        inputTC.put("the", 5);
        inputTC.put("shore", 6);
        inputTC.put("see", 7);
        trie.createTrieST(inputTC);

        switch(Integer.parseInt(args[0])) {
            case 1:
                System.out.println("Doing startsWithTCs");
                startsWithTCs(trie); break;
            case 2:
                System.out.println("Doing longestPrefixTCs");
                longestPrefixOfTCs(trie); break;
            case 3:
                System.out.println("Doing KeysMatchOf");
                KeysMatchOf(trie); break;
            default:
                System.out.println("No valid case selecte");
        }



    }

    private static void  KeysMatchOf(TrieST<Integer> trie) {

        Map<String, List<String>> KeysMatchOf = new HashMap<>();
        KeysMatchOf.put("s.a", new ArrayList<String>(Arrays.asList("sea")));
        KeysMatchOf.put("s.e", new ArrayList<String>(Arrays.asList("see", "she")));
        KeysMatchOf.put("sh.re", new ArrayList<String>(Arrays.asList("shore")));

        // KeysMatchOf - TCs start
        int totalCases = KeysMatchOf.keySet().toArray().length;
        int passedCases = 0;

        int i = 1;
        System.out.println("Searching Trie Tree");
        for (Map.Entry<String, List<String>> entry : KeysMatchOf.entrySet()) {
            System.out.println("Searching for: " + entry.getKey() + " in KeysMatchOf for value: " + entry.getValue());
            Iterable<String> result = trie.keysMatchOf(entry.getKey());
            if (validateResult(result, entry.getValue())) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + i);
            }
            i++;
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }

        // KeysMatchOf  TCs end
    }

    private static void  longestPrefixOfTCs(TrieST<Integer> trie) {

        Map<String, List<String>> longestPrefixOf = new HashMap<>();
        longestPrefixOf.put("she", new ArrayList<String>(Arrays.asList("she", "3")));
        longestPrefixOf.put("shell", new ArrayList<String>(Arrays.asList("she", "3")));
        longestPrefixOf.put("shellsort", new ArrayList<String>(Arrays.asList("shells", "6")));
        longestPrefixOf.put("shelters", new ArrayList<String>(Arrays.asList("she", "3")));

        // longestPrefix - TCs start
        int totalCases = longestPrefixOf.keySet().toArray().length;
        int passedCases = 0;

        int i = 1;
        System.out.println("Searching Trie Tree");
        for (Map.Entry<String, List<String>> entry : longestPrefixOf.entrySet()) {
            System.out.println("Searching for: " + entry.getKey() + " in longestPrefixOf for value: " + entry.getValue());
            String result = trie.longestPrefixOf(entry.getKey());
            if (entry.getValue().get(0).equals(result)) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + i);
            }
            i++;
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }

        // longestPrefix  TCs end
    }

    private static void startsWithTCs(TrieST<Integer> trie) {

        Map<String, List<String>> startsWith = new HashMap<>();
        startsWith.put("sh", new ArrayList<String>(Arrays.asList("she", "shells", "shore")));
        startsWith.put("se", new ArrayList<String>(Arrays.asList("sea", "sells")));
        startsWith.put("th", new ArrayList<String>(Arrays.asList("the")));

        // starts with - TCs start
        int totalCases = startsWith.keySet().toArray().length;
        int passedCases = 0;
        int i = 1;
        System.out.println("Searching Trie Tree");
        for (Map.Entry<String, List<String>> entry : startsWith.entrySet()) {
            System.out.println("Searching for: " + entry.getKey() + " in keysWithPrefix for value: " + entry.getValue());
            Iterable<String> result = trie.keysWithPrefix(entry.getKey());
            if (validateResult(result, entry.getValue())) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + i);
            }
            i++;
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }

        // starts with TCs end
    }

    private static boolean validateResult(Iterable<String> it, List<String> expectedList) {
        Set<String> actualSet = new HashSet<>();
        for (String s : it) actualSet.add(s);

        Set<String> expectedSet = new HashSet<>(expectedList);
        if (!expectedSet.equals(actualSet)) {
            return false;
        }
        return true;
    }
}
