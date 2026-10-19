package com.sk.algos.ds.newseries.find;

import java.util.HashMap;
import java.util.Map;

/* incomplete */
public class QuickFindByMap {

    Map<Integer, Integer> items;
    int itemSize;

    public QuickFindByMap(int size) {
        itemSize = size;
        items = new HashMap<>();
        for (int i = 0; i < size; i++) {
            items.put(i, i);
        }
    }

    public boolean isConnected(int p, int q) {
        return items.get(p) == items.get(q);
    }

    public boolean union(int p, int q) {
        int idp = items.get(p);
        int idq = items.get(q);

        if (idp == idq) {
            return false; // already connected
        }

        items.put(p,idq);
       /* for (int i = 0; i < itemSize; i++) {
            if (items[i] == idp) {
                items[i] = idq;
            }
        }*/

        return true;
    }

    public boolean doOperation(int operation, int[] values) {
        if (operation == 1) {
           return union(values[0], values[1]);
        } else if (operation == 0) {
            return isConnected(values[0], values[1]);
        } else {
            System.out.println("Invalid operation");
        }
        return false;
    }


    public static void main(String[] args) {

        int[][] inputTC = { {4, 3},
                {3, 8},
                {6,5},
                {9,4},
                {9,8},
                {5,0}
        };
        // 1 is union , 0 is find
        int[] input2TC = { 1, 1, 1, 1, 0, 0
        };
        boolean[] resultTC = { true,
                true,
                true,
                true,
                true,
                false
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        QuickFindByMap qf = new QuickFindByMap(10);
        for (int cntr=0; cntr < inputTC.length; cntr++) {
            boolean result = qf.doOperation(input2TC[cntr], inputTC[cntr]);
            if ( result == resultTC[cntr] ) {
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        }else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
        }

    }
}
