package com.sk.algos.ds.newseries.algos.twopointer;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftH = height[left];
            int rightH = height[right];

            int h = leftH < rightH ? leftH : rightH;
            int area = h * (right - left);

            //System.out.println("h: " + h + " area: " + area + " leftH: " + leftH + " rightH: " + rightH);

            if (area > result) {
                result = area;
                //System.out.println("result: " + result);
            }


            if (leftH < rightH) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        int[][] inputTC = {
                {1,8,6,2,5,4,8,3,7},
                {1,1}
        };

        int[] resultTC = {
                49,
                1

        };
        int totalCases = inputTC.length;
        int passedCases = 0;

        ContainerMostWater waterObj = new ContainerMostWater();
        for (int cntr = 0; cntr < inputTC.length; cntr++) {
            int result = waterObj.maxArea(inputTC[cntr]);
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
