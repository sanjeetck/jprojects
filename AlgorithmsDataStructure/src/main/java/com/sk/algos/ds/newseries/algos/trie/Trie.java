package com.sk.algos.ds.newseries.algos.trie;

/* From LeetCode */
class Trie {

    private static int radix = 26;
    private static final int MARKER = 97;
    private Node root;

    private class Node {
        boolean terminal = false;
        Node[] next = new Node[radix];
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int d) {
        if (x == null)  x = new Node();

        if (d == word.length()) {
            x.terminal = true;
            return x;
        }

        int index = word.charAt(d) - MARKER;
        x.next[index] = insert(x.next[index], word, d+1);
        return x;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node x, String word, int d) {
        if (x == null) return false;

        if (d == word.length()) {
            if (x.terminal) {
                return true;
            }else {
                return false;
            }
        }

        int index = word.charAt(d) - MARKER;
        return search(x.next[index], word, d+1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node x, String prefix, int d) {
        if (x == null) return false;

        if (d == prefix.length()) {
            return true;
        }

        int index = prefix.charAt(d) - MARKER;
        return startsWith(x.next[index], prefix, d+1);
    }

}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */