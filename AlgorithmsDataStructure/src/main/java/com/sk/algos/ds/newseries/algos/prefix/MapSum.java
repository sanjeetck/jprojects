package com.sk.algos.ds.newseries.algos.prefix;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private static int radix = 26;
    private static final int MARKER = 97;
    private Node root;
    Map<String, Integer> keyMap;

    private class Node {
        int prefixSum = 0;
       // boolean terminal = false;
        Node[] next = new Node[radix];
    }

    public MapSum() {
        root = new Node();
        keyMap = new HashMap<>();
    }

    public void insert(String word, int sum) {
        int delta = sum - keyMap.getOrDefault(word, 0);
        System.out.println("delta :" + delta);

        keyMap.put(word, sum);

        root = insert(root, word, delta, 0);
    }

    private Node insert(Node x, String word, int delta, int d) {
        if (x == null)  x = new Node();

        if (x != root) {
            x.prefixSum += delta;
        }
        if (d == word.length()) {
            return x;
        }

        int index = word.charAt(d) - MARKER;
        x.next[index] = insert(x.next[index], word, delta, d+1);
        return x;
    }

    public int sumPrefix(String prefix) {
        return sumPrefix(root, prefix, 0);
    }

    private int sumPrefix(Node x, String prefix, int d) {
        if (x == null) return 0;

        if (d == prefix.length()) {
            return x.prefixSum;
        }

        int index = prefix.charAt(d) - MARKER;
        return sumPrefix(x.next[index], prefix, d+1);
    }
}
