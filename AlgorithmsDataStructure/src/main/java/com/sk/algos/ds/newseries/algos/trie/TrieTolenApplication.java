package com.sk.algos.ds.newseries.algos.trie;

import java.util.*;

public class TrieTolenApplication {
    public static void main(String[] args) {
        TrieToken trie = new TrieToken();

        // Input data for test cases
        Map<String, String> inputTC = new HashMap<>();
        inputTC.put("she abc", "APLE");
        inputTC.put("sells not one", "NOBLE");
        inputTC.put("what the hell", "META");
        inputTC.put("shells it with one", "PETA");
        inputTC.put("by the", "ZETA");
        inputTC.put("by the way", "KETA");

        Map<String, List<String>> searchFor = new HashMap<>();
        searchFor.put("she abc sells the by best of what the hell one", new ArrayList<>(Arrays.asList("APLE", "META")));
        searchFor.put("she sells not one best by the way", new ArrayList<>(Arrays.asList("NOBLE", "ZETA", "KETA")));

        int totalCases = searchFor.keySet().toArray().length;
        int passedCases = 0;
        trie.createTrieST(inputTC);
        int i = 1;
        System.out.println("Searching Trie Tree");
        for (Map.Entry<String,  List<String>> entry : searchFor.entrySet()) {
            System.out.println("Searching for: " + entry.getKey() + " with value: " + entry.getValue());
            List<String> q = new ArrayList<>();
            String[] words = entry.getKey().split(" ");
            trie.tokenTraversal(words, q);
            List<String> rsult = q;
            if (  rsult.equals(searchFor.get(entry.getKey()))) {
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

    }
}
