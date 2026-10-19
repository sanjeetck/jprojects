package com.sk.algos.ds.newseries.find;

public class QuickFind {

    int itemList[];

    public QuickFind(int size) {
        itemList = new int[size];
        for (int i = 0; i < size; i++) {
            itemList[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return itemList[p] == itemList[q];
    }

    public boolean union(int p, int q) {
        int idp = itemList[p];
        int idq = itemList[q];

        if (idp == idq) {
            return false; // already connected
        }

        itemList[p] = idq;
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] == idp) {
                itemList[i] = idq;
            }
        }

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
        QuickFind qf = new QuickFind(10);
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
