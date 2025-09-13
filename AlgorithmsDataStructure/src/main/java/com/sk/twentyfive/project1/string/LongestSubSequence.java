package com.sk.twentyfive.project1.string;

public class LongestSubSequence {

    public static int longestSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] grid = new int[len1+1][len2+1];
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        for (int i=1; i <= len1; i++) {
            for (int j=1; j <= len2; j++) {
                if (t1[i-1] == t2[j-1]) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                }else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[len1][len2];
    }

    public static void main(String[] args) {
        boolean java8Ver = false;
        String[] strTC = {
                "abcde",
                "abc",
                "abc",
                "abcd"
        };
        String[] strTC2 = {
                "ace",
                "abc",
                "def",
                "abcd"
        };

        int[] resultTC = {
                3,
                3,
                0,
                4

        };

        int totalCases = strTC.length;
        int passedCases = 0;
        for (int cntr=0; cntr < strTC.length; cntr++) {
            if (longestSubsequence(strTC[cntr],strTC2[cntr]) == (resultTC[cntr])) {
                passedCases++;
            }else {
                System.out.println("Failed case :" + (cntr + 1));
            }

        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        }else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases));
        }

    }
}
