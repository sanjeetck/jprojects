package com.sk.twentyfive.project1.string;

public class ReverseWords {

    public static String reverseWords(String s) {
        if (s.indexOf(" ") == -1) return s;

        String strArry[] = s.split(" ");
        StringBuilder newStr = new StringBuilder();
        for (int j=strArry.length-1; j >= 0; j--) {
            if (strArry[j].trim().equals("")) continue;
            newStr.append(strArry[j].trim());
            newStr.append(" ");
        }
        return newStr.toString().trim();
    }

    public static void main(String[] args) {
        String[] strTC = {
                "a good   example",
                "  hello world  ",
                "the sky is blue",
                "abcd"
        };
        String[] resultTC = {
                "example good a",
                "world hello",
                "blue is sky the",
                "abcd"
        };

        int totalCases = strTC.length;
        int passedCases = 0;
        for (int cntr=0; cntr < strTC.length; cntr++) {
            if (reverseWords(strTC[cntr]).equals(resultTC[cntr])) {
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
