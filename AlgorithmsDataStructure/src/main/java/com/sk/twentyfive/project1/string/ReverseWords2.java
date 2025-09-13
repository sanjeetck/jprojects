package com.sk.twentyfive.project1.string;

import java.util.Arrays;

// incomplete
public class ReverseWords2 {

    public static String reverseWords(String s) {
        char[] c = s.toCharArray();

        int len = c.length;

        char[] c2 = new char[len];
        String str2 = "";
        int writeAtIdx = len;
        System.out.println("c : " + Arrays.toString(c) + "::writeAtIdx: " + writeAtIdx);
        for (int i = 0; i < len; i++) {
            System.out.println("Index i1:" + i );
            while (i < len && c[i] == ' ') { i++;continue; }
            if (!(i < len)) break;
            int startIndex = i;
            System.out.println("Index i2:" + i );
            System.out.println("Char at " + i + ": " + c[i] + "::startIndex: " + startIndex);
            //c2[i] = c[i]; i++;
            while (i < len && c[i] != ' ') { i++; continue; };
            int endIndex = i;
            writeAtIdx = writeAtIdx - (endIndex - startIndex);
            int marker = writeAtIdx;
            System.out.println("marker " + marker +"::writeAtIdx " + writeAtIdx + "::endIndex: " + endIndex);

            for (int k=startIndex; k < endIndex; k++) {
                c2[writeAtIdx++] = c[k];
            }
            writeAtIdx = marker;
            if(!(writeAtIdx < 1)) {
                c2[--writeAtIdx] = ' ';
            }
            System.out.println("c2 : " + Arrays.toString(c2) +"::writeAtIdx " + writeAtIdx);
        }

        return String.valueOf(c2).trim();
    }

    public static void main(String[] args) {
        boolean java8Ver = false;
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
