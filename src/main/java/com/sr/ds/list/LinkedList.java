package com.sr.ds.list;

public abstract class LinkedList {
    // Even though Node has prev,
    // for single linked list it will not be set
    // head of the list
    Node head;
    
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
        }

        Node(Node prev, int d) {
            this.prev = prev;
            data = d;
        }

        Node(int d, Node next) {
            data = d;
            this.next = next;
        }

        Node(Node prev, int d, Node next) {
            this.prev = prev;
            data = d;
            this.next = next;
        }
    }

    abstract void insertAtStart(int x);

    abstract void insertBefore(int value, int x);

    abstract void insertAfter(int value, int x);

    abstract void insertAtEnd(int x);

    abstract void remove(int x);

    abstract void print();

    abstract void reverse();

    void print(Node head, String separator) {
        Node node = head;
        StringBuilder builder = new StringBuilder("");
        while (node != null) {
            builder.append(node.data).append(separator);
            node = node.next;
        }
        builder.append("null");
        System.out.print("\nLinked list \n" + builder);
    }
}