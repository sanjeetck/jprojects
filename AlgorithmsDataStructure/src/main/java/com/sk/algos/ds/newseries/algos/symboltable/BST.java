package com.sk.algos.ds.newseries.algos.symboltable;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

     class Node {
        private Key key;
        private Value val;

        private Node left, right;

        private int N;

        private Node(Key k, Value v, int N) {
            this.key = k;
            this.val = v;
            this.N = N;
        }

    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            System.out.println("Not Found : " +key);
            return null;
        }

        System.out.println("Comparing to : " + x.key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else {
            System.out.println("Found : " + x.key);
            return x.val; // cmp == 0
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            System.out.println("Adding node with key: " + key);
            return new Node(key, val, 1);
        }

        System.out.println("Comparing node to : " + x.key);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val; // cmp == 0

        x.N = size(x.left) + size(x.right) +1 ;

        return x;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

}
