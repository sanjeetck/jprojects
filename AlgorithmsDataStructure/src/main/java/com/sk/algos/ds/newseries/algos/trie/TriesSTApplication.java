package com.sk.algos.ds.newseries.algos.trie;

import java.util.HashMap;
import java.util.Map;

public class TriesSTApplication {


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

        Map<String, Integer> searchFor = new HashMap<>();
        searchFor.put("she", 0);
        searchFor.put("sell", null);
        searchFor.put("sea", 2);
        searchFor.put("shell", null);
        searchFor.put("by", 4);

        int totalCases = searchFor.keySet().toArray().length;
        int passedCases = 0;
        trie.createTrieST(inputTC);
        int i = 1;
        System.out.println("Searching Trie Tree");
        for (Map.Entry<String, Integer> entry : searchFor.entrySet()) {
            System.out.println("Searching for: " + entry.getKey() + " with value: " + entry.getValue());
            Integer result = trie.get(entry.getKey());
            if ( (result == null &&
                    searchFor.get(entry.getKey()) == null ) ||
                    searchFor.get(entry.getKey()).equals(result)) {
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