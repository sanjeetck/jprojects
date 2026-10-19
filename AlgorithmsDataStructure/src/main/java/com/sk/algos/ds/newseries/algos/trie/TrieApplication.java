package com.sk.algos.ds.newseries.algos.trie;

import java.util.Arrays;

public class TrieApplication {


    public static void main(String[] args) {
        String[][] inputTC = {
                {"init", ""},
                {"insert", "apple"},
                {"search", "apple"},
                {"search", "app"},
                {"startsWith", "app"},
                {"insert", "app"},
                {"search", "app"}
        };

        String[][] resultTC = {
                {"init", null},
                {"insert", null},
                {"search", "true"},
                {"search", "false"},
                {"startsWith", "true"},
                {"insert", null},
                {"search", "true"}
        };


        int totalCases = inputTC.length;
        int passedCases = 0;
        int i = 1;
        Trie trie = new Trie();
        String[][] actualResults  = new String[totalCases][2];

        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            String command = inputTC[cntr][0];
            String value = inputTC[cntr][1];

            if (command.equals("init")) {
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = null;
            }else if (command.equals("insert")) {
                trie.insert(value);
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = null;
            }else if (command.equals("search")) {
                boolean result = trie.search(value);
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = Boolean.toString(result);
            }else if (command.equals("startsWith")) {
                boolean result = trie.startsWith(value);
                actualResults[cntr][0] = command;
                actualResults[cntr][1] = Boolean.toString(result);
            }
        }

        for (int cntr = 0; cntr < actualResults.length; cntr++) {
            System.out.println(actualResults[cntr][0] + " :: " +actualResults[cntr][1]);
            if (Arrays.deepEquals(actualResults[cntr], resultTC[cntr])) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + i);
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }

    }
}