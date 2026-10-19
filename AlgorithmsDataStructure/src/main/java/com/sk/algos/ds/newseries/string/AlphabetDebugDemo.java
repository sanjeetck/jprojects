package com.sk.algos.ds.newseries.string;

import java.util.Arrays;

public class AlphabetDebugDemo {

    public static void main(String[] args) {
        System.out.println("=== DNA Alphabet Character Count Demo ===\n");

        // Create DNA alphabet
        Alphabet dna = Alphabet.DNA;  // "ACGT"

        System.out.println("1. Alphabet created: ACGT");
        System.out.println("   Radix (R) = " + dna.radix() + "\n");

        // Input string
        String input = "GAGTACA";
        System.out.println("2. Input string: \"" + input + "\"\n");

        // ===== STEP 1: Show inverse mapping (char -> index) =====
        System.out.println("3. Character to Index mapping (inverse array):");
        for (char c : new char[]{'A', 'C', 'G', 'T'}) {
            int idx = dna.toIndex(c);
            System.out.println("   '" + c + "' -> " + idx);
        }
        System.out.println();

        // ===== STEP 2: Convert string to indices =====
        System.out.println("4. Converting string to indices using toIndices():");
        int[] indices = dna.toIndices(input);
        System.out.println("   Input:   " + input);
        System.out.println("   Indices: " + Arrays.toString(indices));
        System.out.println("   (each character maps to its position in ACGT)\n");

        // ===== STEP 3: Detailed character-by-character breakdown =====
        System.out.println("5. Character-by-character breakdown:");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int idx = indices[i];
            System.out.println("   input[" + i + "] = '" + c + "' -> indices[" + i + "] = " + idx);
        }
        System.out.println();

        // ===== STEP 4: Count frequencies =====
        System.out.println("6. Counting frequencies using index array:");
        int[] count = new int[dna.radix()];
        for (int i = 0; i < input.length(); i++) {
            count[indices[i]]++;
            System.out.println("   count[" + indices[i] + "]++ -> count = " + Arrays.toString(count));
        }
        System.out.println();

        // ===== STEP 5: Display results using toChar (index -> char) =====
        System.out.println("7. Index to Character mapping (alphabet array) and final counts:");
        for (int c = 0; c < dna.radix(); c++) {
            char ch = dna.toChar(c);
            System.out.println("   index " + c + " -> '" + ch + "' : appears " + count[c] + " times");
        }
        System.out.println();

        // ===== SUMMARY =====
        System.out.println("8. Summary:");
        System.out.println("   A: " + count[0] + " times");
        System.out.println("   C: " + count[1] + " times");
        System.out.println("   G: " + count[2] + " times");
        System.out.println("   T: " + count[3] + " times");
    }
}
