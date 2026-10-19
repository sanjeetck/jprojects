package com.sk.algos.ds.newseries.algos.trie;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class TrieST<Value> {

    private static int R = 256; // key length max and fixed
    private Node root;
    Pattern pattern = Pattern.compile("[a-z]+");

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        System.out.println("Output: " + x.val);
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        System.out.println("Adding Key: " + key + " with value: " + val);
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public void createTrieST(Map<String, Value> inputs) {
        System.out.println("Creaeting Trie Tree");
        for (Map.Entry<String, Value> entry : inputs.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    // prefix with
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, prefix, 0), prefix, q);
        return q;
    }

    private void collect(Node x, String word, Queue<String> q) {
        if (x == null) return;

        if (x.val != null) q.add(word);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], word + c, q);
        }
    }

    // longest prefix of
    public String longestPrefixOf(String word) {
        int length = search(root, word, 0, 0);
        return word.substring(0, length);
    }

    private int search(Node x, String word, int d, int length) {
        System.out.println("Calling search with word: " + word.substring(0,d) + " with d:" + d +  " with length:" + length);
        if (x == null) {
            System.out.println("At x==null, d: "+ d + " length: " + length);
            return length;
        }

        if (x.val != null) {
            System.out.println("At x.val != null, d: "+ d + " length: " + length + " x.val: " + x.val);
            length = d;
        }

        if (d == word.length()) {
            System.out.println("At d == word.length(), d: "+ d + " length: " + length + " x.val: " + x.val);
            return length;
        }

        char c = word.charAt(d);
        return search(x.next[c], word, d+1, length);

    }

    // wild card - keysMatchOf
    public Iterable<String> keysMatchOf(String pattern) {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pattern, q);
        return q;
    }

    private void collect(Node x, String pre, String pattern, Queue<String> q) {
        if (pre.matches(pattern))
            System.out.println("Call pre: " + pre + " pattern:" + pattern);
        int d = pre.length();
        if (x == null) {
            if (pre.matches(pattern))
                System.out.println("at x == null d:" + d + " pre:" + pre);
            return;
        }

        if (d == pattern.length() && x.val != null) {
            q.add(pre);
            System.out.println("at x.val != null d:" + d + " pre:" + pre + " queue: "+ q.toString());
        }
        if (d == pattern.length()) {
            System.out.println("at d == pattern.length() d:" + d + " pre:" + pre);
            return;
        }

        char next = pattern.charAt(d);
        System.out.println("Next: " + next + " d:" + d);

        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                if (pre.matches(pattern))
                    System.out.println("Next char: " + c + " pre: " + pre+c);
                collect(x.next[c], pre + c, pattern, q);
            }
        }
    }

}

