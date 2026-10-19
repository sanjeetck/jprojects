package com.sk.algos.ds.newseries.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count {

    public static void main(String args[]) throws IOException {
        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.R();

        int[] count = new int[R];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int N = s.length();

       /* for (int i=0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) {
                count[alpha.toIndex(s.charAt(i))]++;
            }
        }*/

        int[] a = alpha.toIndices(s);
        for (int i = 0; i < N; i++)
            count[a[i]]++;

        for (int c=0; c< R; c++) {
            System.out.println(alpha.toChar(c) + " " + count[c]);
        }
    }
}
