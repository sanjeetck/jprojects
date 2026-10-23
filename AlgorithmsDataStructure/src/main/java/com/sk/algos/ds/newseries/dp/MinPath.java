package com.sk.algos.ds.newseries.dp;

public class MinPath {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int[][] f = new int[m][n];

        f[0][0] = grid[0][0];
        for (int j=1; j < n; j++) {
            f[0][j] = f[0][j-1] + grid[0][j];
        }

        for (int i=1; i < m; i++) {
            f[i][0] = f[i-1][0] + grid[i][0];
        }

        int minV, left, top;
        for (int i=1; i < m; i++) {
            for (int j=1; j < n; j++) {
                left = f[i][j-1];
                top = f[i-1][j];

                if ( left < top) minV = left;
                else minV = top;
                f[i][j] = minV + grid[i][j];
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][][] inputTC = {
                {{1,2,3},{4,5,6}},
                {{1,3,1},{1,5,1},{4,2,1}}
        };

        int[] resultTC = {
                12,
                7
        };
        int totalCases = inputTC.length;
        int passedCases = 0;

        MinPath minPathObj = new MinPath();
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = minPathObj.minPathSum(inputTC[cntr]);
            System.out.println("Result:" + result);
            if (result == resultTC[cntr]) {
                System.out.println("Case passed");
                passedCases++;
            }
        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed :(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
