package com.sk.algos.ds.newseries.matrix;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i =1; i < row; i++) {
            for (int j=1; j < col; j++) {
                // start with 1,1 and check if value matches its i-1, j-1
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
