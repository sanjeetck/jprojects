package com.sk.algos.ds.newseries.algos.trie;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class TrieToken {

    private static int R = 256; // key length max and fixed
    private Node root;
    Pattern pattern = Pattern.compile("[a-z]+");
    private final String SPACE = " ";

    private static class Node {
        private String val;
        boolean isTerminal = false;
        private Node[] next = new Node[R];
    }

    public String get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        System.out.println("Output: " + x.val);
        return x.val;
    }

    public void tokenTraversal(String keys[], List<String> q) {
        int d = 0;
        boolean restart = true;
        Node nCurr = get(root, keys[0], d);
        if (nCurr != null) {
            restart = false;
        }
        Node nNext = null;
        for (int i = 1; i < keys.length; i++) {
            if (restart) {
                nCurr = get(root, keys[i], d);
                if (nCurr != null) { restart = false; }
            } else {
                nNext = get(nCurr, SPACE + keys[i], d);
                if (nNext == null) {
                    restart = true;
                    i--;
                }else {
                    if (nNext.isTerminal) q.add(nNext.val);
                }
                nCurr = nNext;
            }
        }
        return;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, String val) {
        System.out.println("Adding Key: " + key + " with value: " + val);
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, String val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            x.isTerminal = true;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public void createTrieST(Map<String, String> inputs) {
        System.out.println("Creaeting Trie Tree");
        for (Map.Entry<String, String> entry : inputs.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

}
