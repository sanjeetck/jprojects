package com.sk.algos.ds.newseries.find;

public class QuickUnion {

    int itemList[];

    public QuickUnion(int size) {
        itemList = new int[size];
        for (int i = 0; i < size; i++) {
            itemList[i] = i;
        }
    }


    private int root(int i) {
        int counter = 0;
        while(i  != itemList[i])  {
            i = itemList[i];
            counter++;
        }
        System.out.println(i + ": counter: " + counter);
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public boolean union(int p, int q) {
        itemList[p] = q;
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
                {5,0},
                {2,1},
                {0,5},
                {7,2},
                {5,6}
        };
        // 1 is union , 0 is find
        int[] input2TC = { 1, 1, 1, 1, 0, 0, 1, 0, 1, 0
        };
        boolean[] resultTC = {
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                false,
                true,
                true
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        QuickUnion qf = new QuickUnion(10);
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
