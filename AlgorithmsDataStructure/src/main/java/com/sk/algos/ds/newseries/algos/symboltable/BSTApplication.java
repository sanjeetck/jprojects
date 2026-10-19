package com.sk.algos.ds.newseries.algos.symboltable;

import java.util.Arrays;

public class BSTApplication {


    public boolean[] bstCreateAndSearch(BST<Integer, String> bst, Integer[] keys, String[] values, Integer[] searchKeys) {
        System.out.println("Bst create with array : " + Arrays.toString(keys));
        for (int i = 0; i < keys.length; i++) {
            bst.put(keys[i], values[i]);
        }

        boolean[] results = new boolean[searchKeys.length];
        System.out.println("Bst search for array : " + Arrays.toString(searchKeys));

        for (int i = 0; i < searchKeys.length; i++) {
            System.out.println("Searching for : " + searchKeys[i]);
            if (bst.get(searchKeys[i]) != null) {
                System.out.println("Found: " + searchKeys[i]);
                results[i] = true ;
            }else {
                System.out.println("Not Found: " + searchKeys[i]);
                results[i] = false;
            }
        }
        return results;
    }



    public static void main(String[] args) {
        BSTApplication bstApp =  new BSTApplication();
        Integer[][] inputTC = {
                {10, 5,2, 3},
                {6,7, 5},
                {3,2,5,4,1,9,8,6,7,10},
                // {3,2,5,4,1,9,8,6,7},
                {25,20, 5,30}
        };

        String[][] inputTC2 = {
                {"a", "b", "c", "d"},
                {"a", "b", "c" },
                {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"},
                {"a", "b", "c", "d"}
        };

        Integer[][] inputTC3 = {
                {10, 20},
                {16,3},
                {11, 1},
                {20, 5}
        };

        boolean[][] searchResults = {
                {true, false},
                {false, false},
                {false, true},
                {true, true}
        };

      /*  int[][] resultTC = {
                {2, 3,5,10},
                {5,6,7},
                {1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9},
                {5,20,25,30}
        };*/

        int totalCases = inputTC.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            BST<Integer, String> bst = new BST<>();
            boolean results[] = bstApp.bstCreateAndSearch(bst, inputTC[cntr], inputTC2[cntr], inputTC3[cntr]);
            if (Arrays.equals(results, searchResults[cntr])) {
                passedCases++;
            } else {
                System.out.println("Failed case :" + (cntr + 1));
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
