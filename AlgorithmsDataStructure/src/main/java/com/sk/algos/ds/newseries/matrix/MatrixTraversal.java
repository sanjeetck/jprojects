package com.sk.algos.ds.newseries.matrix;

import java.util.Arrays;

public class MatrixTraversal {

    public int[] findDiagonalOrder(int[][] mat) {
        int maxR = mat.length;
        int maxC = mat[0].length;

        int[] arr = new int[maxR * maxC];
        int arrIndex = 0;
        int currR=0, currC=0;
        boolean dir=true; // true up, right ; false down. left

        while (arrIndex < arr.length) {

            if (dir) { // going up, right
                while (currR >= 0 && currC < maxC) {
                    System.out.println("currR: " +currR + " currC: " + currC);
                    arr[arrIndex++] = mat[currR][currC];
                    currR--;
                    currC++;
                }

                if (currC == maxC) {
                    currC--;
                    currR += 2;
                }else {
                    currR++;
                }
                dir = !dir;
            }else {
                while (currR < maxR && currC >= 0) {
                    System.out.println("currR: " +currR + " currC: " + currC);
                    arr[arrIndex++] = mat[currR][currC];
                    currC--;
                    currR++;
                }

                if (currR == maxR) {
                    currR--;
                    currC += 2;
                }else {
                    currC++;
                }
                dir = !dir;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[][][] inputTC = { {{1,2,3},{4,5,6},{7,8,9}},
                {{1,2,5,7},{8,9,10,12},{15,20,25,26}}
        };

        int[][] resultTC = { {1,2,4,7,5,3,6,8,9},
                {1,2,8,15,9,5,7,10,20,25,12,26}
        };

        int totalCases = inputTC.length;
        int passedCases = 0;
        MatrixTraversal traversal = new MatrixTraversal();
        for (int cntr=0; cntr < inputTC.length; cntr++) {
            int[] results = traversal.findDiagonalOrder(inputTC[cntr]);
            if (Arrays.equals(results, resultTC[cntr]) ) {
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
