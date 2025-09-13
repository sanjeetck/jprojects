package com.sk.twentyfive.project1.algos2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff2 {
    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set nums1Set = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set nums2Set = IntStream.of(nums2).boxed().collect(Collectors.toSet());


        Set toRemove = new HashSet();
        nums1Set.stream().forEach(element -> {
            if (nums2Set.contains(element)){
                System.out.println("element : " + element);
                toRemove.add(element);
            }
        });

        toRemove.stream().forEach(element -> {
                nums2Set.remove(element);
                nums1Set.remove(element);
        });

        List<List<Integer>> diffList = new ArrayList<>();
        diffList.add( (List<Integer>) nums1Set.stream().collect(Collectors.toList()));
        diffList.add( (List<Integer>) nums2Set.stream().collect(Collectors.toList()));
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
