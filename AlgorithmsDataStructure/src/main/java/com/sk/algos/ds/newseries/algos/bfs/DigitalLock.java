package com.sk.algos.ds.newseries.algos.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class DigitalLock {

    public static void main(String[] args) {

        String[][] inputTC = {
                {"8887","8889","8878","8898","8788","8988","7888","9888"},
                {"8888"},
            //    {"0201","0101","0102","1212","2002"}
        };

        String[] targetTC = {
                "8888",
                "0009",
              //  "0202"
        };
        int[] resultTC = {
                -1,
                1,
             //   6
        };
        int totalCases = inputTC.length;
        int passedCases = 0;
        DigitalLock digiLock = new DigitalLock();
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = digiLock.openLock(inputTC[cntr], targetTC[cntr]);
            System.out.println("Result:" + result);
            if (result == resultTC[cntr]) {
                System.out.println("Case passed");
                passedCases++;
            }
        }


        if (totalCases == passedCases) {
            System.out.println("Total cases passed openLock :(" + passedCases + "/" + totalCases + ")");
        } else {
            System.out.println("Nomber of cases failed openLock: " + (totalCases - passedCases) + " out of " + totalCases);
        }

    }
    public  int openLock(String[] deadends, String target) {
        int length = target.length();
        String initial = "0000";

        Set<String> deadendsSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String str: deadends) {
            deadendsSet.add(str);
        }

        if (deadendsSet.contains(initial)) {
            return -1;
        }
        if (initial.equals(target)) {
            return 0;
        }

        Queue<Pair<String, Integer>> q = new ArrayDeque<>();
        q.add(Pair.of(initial, 0));
        visited.add(initial);

        while(!q.isEmpty()) {
            Pair<String, Integer> pair = q.poll();
            String element = pair.getLeft();
            int currentSteps = pair.getRight();
            if (element.equals(target)) {
                return pair.getRight();
            }

            for (int i = 0; i < length; i++) {
                String[] mutations = {getNext(element, i), getPrev(element, i)};
                for (String mutation : mutations) {
                    if (!deadendsSet.contains(mutation) && visited.add(mutation)) {
                        q.add(Pair.of(mutation, currentSteps + 1));
                    }
                }
            }
            System.out.println("After adding mutations: " + q);
        }

        System.out.println("Queue empty, -1");
        return -1;
    }

    private String getNext(String element, int lockNumber) {
        int[] targetInts = str2Array(element);

        targetInts[lockNumber] = targetInts[lockNumber] + 1;

        if (targetInts[lockNumber] == 10) {
            targetInts[lockNumber] = 0;
        }

        return arr2String(targetInts);
    }

    private String getPrev(String element, int lockNumber) {
        int[] targetInts = str2Array(element);

        targetInts[lockNumber] = targetInts[lockNumber] - 1;
        if (targetInts[lockNumber] == -1) {
            targetInts[lockNumber] = 9;
        }

        return arr2String(targetInts);
    }

    private int[] str2Array(String element){
        int[] targetInts = new int[element.length()];
        for (int i=0; i < element.length(); i++) {
            char ch = element.charAt(i);
            targetInts[i] = Character.getNumericValue(ch);
        }
        return targetInts;
    }

    private String arr2String(int[] element) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < element.length; i++) {
            sb.append(element[i]);
        }
        return sb.toString();
    }
}
