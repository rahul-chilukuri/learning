package com.base.ds.nodes;

public class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node child;

    public Node() {
    }

    public Node(int d) {
        val = d;
    }

    public Node(Node prev, int d) {
        this.prev = prev;
        val = d;
    }

    public Node(int d, Node next) {
        val = d;
        this.next = next;
    }

    public Node(Node prev, int d, Node next) {
        this.prev = prev;
        val = d;
        this.next = next;
    }

    public Node(Node prev, int d, Node next, Node child) {
        this.prev = prev;
        val = d;
        this.next = next;
        this.child = child;
    }
}