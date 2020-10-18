package com.sr.ds.linkedlist;

class LinkedList {
    Node head; // head of the list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) { data = d; }
    }

    void printList() {
        Node node = head;
        while(node != null ) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    void insertAtStart(Node head, int x) {
        Node firstNode = new Node(x);
        firstNode.next = head;
        head = firstNode;
    }

    void insertAfter(Node prevNode, int x) {
        if(prevNode != null) {
            Node insertNode = new Node(x);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
    }

    void insertAtEnd(Node head, int x) {
        if(head == null) {
            head = new Node(x);
        } else {
            Node lastNode = head;
            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = new Node(x);
        }
    }

    void push(int x) {
        Node firstNode = new Node(x);
        firstNode.next = head;
        head = firstNode;
    }

    void append(int x) {
        if(head == null) {
            head = new Node(x);
        } else {
            Node node = head;
            while(node.next!=null) {
                node = node.next;
            }
            node.next = new Node(x);
        }

    }

    void insertAfterValue(int prevNodeValue, int x) {
        Node node = head;
        while(node != null) {
            if(node.data == prevNodeValue) {
                Node insertNode = new Node(x);
                insertNode.next = node.next;
                node.next = insertNode;
                break;
            }
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();
    }
}