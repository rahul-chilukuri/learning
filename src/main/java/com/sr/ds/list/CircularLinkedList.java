package com.sr.ds.list;

public class CircularLinkedList extends List {

    void insertAtStart(int x) {
        Node firstNode = new Node(x);
        firstNode.next = head;
        this.head = firstNode;
    }

    void insertBefore(int value, int x) {

    }

    void insertAfter(int value, int x) {

    }

    void insertAtEnd(int x) {

    }

    void remove(int x) {

    }

    void reverse() {
    }

    void print() {
        print(head, "-O->");
    }
}