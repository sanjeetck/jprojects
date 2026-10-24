package com.sk.algos.ds.newseries.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {

        if (points.length <= 2) {
            return points.length;
        }

        double slope;
        int result = 0;
        for (int i = 0; i < points.length-1; i++) {
            Map<Double, Integer> slopeFreq = new HashMap<>();
            int maxSlopeFreq = 0;
            for (int j=i+1; j < points.length; j++) {
                double n = points[j][1] - points[i][1];
                double d = points[j][0] - points[i][0];
                System.out.println("n: "+ n + " d: "+ d);
                if (Double.compare(d, 0.0d) != 0) {
                    slope = n/d;
                    if (slope == 0.0) {
                        slope = 0.0;
                    }
                }else {
                    slope = Double.POSITIVE_INFINITY;
                }

                System.out.println("Slope: "+ slope);
                slopeFreq.put(slope, slopeFreq.getOrDefault(slope, 0)+ 1);

                maxSlopeFreq = Math.max(maxSlopeFreq, slopeFreq.get(slope));
                System.out.println("maxSlopeFreq: "+ maxSlopeFreq);
            }
            result = Math.max(result, maxSlopeFreq+1);
            System.out.println("result: "+ result);
        }

        return result;
    }

    public static void main(String[] args) {

        int[][][] inputTC1 = {
                {{1,1}, {2,2}, {3,3}},
                {{0,1}},
                {{0,0}, {1,1}}
        };

        int[] resultTC1 = {
                3,
                1,
                2
        };

        int totalCases = inputTC1.length;
        int passedCases = 0;
        MaxPointsOnLine pointsOnLine = new MaxPointsOnLine();
        for (int cntr = 0; cntr < inputTC1.length; cntr++) {
            System.out.println("Calling TC : " + (cntr+1));
            int result = pointsOnLine.maxPoints(inputTC1[cntr]);
            if (result == resultTC1[cntr]) {
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
