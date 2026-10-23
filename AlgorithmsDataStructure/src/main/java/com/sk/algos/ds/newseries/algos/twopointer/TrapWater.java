package com.sk.algos.ds.newseries.algos.twopointer;

public class TrapWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            int leftH = height[left];
            if (leftH > leftMax) leftMax = leftH;
            int rightH = height[right];
            if (rightH > rightMax) rightMax = rightH;

            if (leftH < rightH) {
                water += leftMax - leftH;
                //System.out.println("Lwater: " + water + " leftH: " + leftH +  " rightH: " + rightH +" leftMax: " + leftMax +" rightMax: " + rightMax);
            }else {
                water += rightMax - rightH;
                //System.out.println("Rwater: " + water + " leftH: " + leftH +  " rightH: " + rightH +" leftMax: " + leftMax +" rightMax: " + rightMax);
            }

            if (leftH < rightH) {
                left++;
            } else {
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {0,1,0,2,1,0,1,3,2,1,2,1},
                {4,2,0,3,2,5}
        };

        int[] resultTC = {
                6,
                9

        };
        int totalCases = inputTC.length;
        int passedCases = 0;

        TrapWater waterObj = new TrapWater();
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = waterObj.trap(inputTC[cntr]);
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
