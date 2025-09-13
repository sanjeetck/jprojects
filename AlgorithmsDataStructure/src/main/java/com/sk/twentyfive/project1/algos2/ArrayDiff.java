package com.sk.twentyfive.project1.algos2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff {
    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] diff1 = new int[nums1.length];
        int cntr = 0;
        for (int i = 0; i < nums1.length; i++) {
            boolean exists = false;
            for (int j =0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                diff1[cntr++] = nums1[i];
            }
        }

        int[] diff2 = new int[nums1.length];
        cntr = 0;
        for (int i = 0; i < nums2.length; i++) {
            boolean exists = false;
            for (int j =0; j < nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                diff2[cntr++] = nums2[i];
            }
        }

        List<Integer> diff1List = IntStream.of(diff1).distinct().filter(i -> i !=0).boxed().collect(Collectors.toList());
        List<Integer> diff2List = IntStream.of(diff2).distinct().filter(i -> i !=0).boxed().collect(Collectors.toList());

        List<List<Integer>> diffList = new ArrayList<>();
        diffList.add(diff1List);
        diffList.add(diff2List);
        return diffList;
    }

    private static void printSubArray(int[] arrayX) {
        Arrays.stream(arrayX).forEach(x -> System.out.print(x + ","));
        System.out.println();
    }


    public static void main(String[] args) {

        int[][] inputTC1 = {
                {1,2,3},
                {1,2,3,3}
        };

        int[][] inputTC2 = {
                {2,4,6},
                {1,1,2,2}
        };

        int[][] resultTC1 = {
                {1,3},
                {3}
        };

        int[][] resultTC2 = {
                {4,6},
                {}
        };
        int totalCases = inputTC1.length;
        int passedCases = 0;
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            List<List<Integer>> result = findDifference(inputTC1[cntr], inputTC2[cntr]);
            int[] result0 =  result.get(0).stream().mapToInt(Integer::intValue).toArray();
            int[] result1 =  result.get(1).stream().mapToInt(Integer::intValue).toArray();
                if (Arrays.equals(result0, resultTC1[cntr]) &&
                        Arrays.equals(result1, resultTC2[cntr])) {
                passedCases++;
            }else {
                System.out.println("Failed TC : " + (cntr+1));
            }

        }

        if (totalCases == passedCases) {
            System.out.println("Total cases passed:(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed : " + (totalCases - passedCases) + " out of " + totalCases);
        }
    }
}
