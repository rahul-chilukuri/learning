package com.base.ds.list;

import com.base.ds.nodes.Node;

public class LinkedList extends DefaultList {

    public void insertAtStart(int x) {
        Node firstNode = new Node(x, head);
        head = firstNode;
    }

    public void insertAfter(int value, int x) {
        assert head != null;
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                Node newNode = new Node(x, node.next);
                node.next = newNode;
                break;
            }
            node = node.next;
        }
    }

    public void insertBefore(int value, int x) {
        assert head != null;
        Node newNode = null;

        Node node = head;
        if (node.data == value) {
            newNode = new Node(x, node);
            head = newNode;
            return;
        }

        while (node.next != null) {
            Node next = node.next;
            if (next.data == value) {
                newNode = new Node(x, next);
                node.next = newNode;
                break;
            }
            node = node.next;
        }
    }

    public void insertAtEnd(int x) {
        if (head == null) {
            head = new Node(x);
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(x);
    }

    public void print() {
        super.print("->");
    }

    public void remove(int value) {
        Node dummy = new Node(-1, head);
        Node next, node = dummy;

        while (node.next != null) {
            next = node.next;
            if (next.data == value) {
                node.next = next.next;
                break;
            }
            node = node.next;
        }

        head = dummy.next;
    }

    public void reverse() {
        Node next, prev = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        List list = new LinkedList();

        // Insert 6. So linked list becomes 6->null
        list.insertAtEnd(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->null
        list.insertAtStart(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->null
        list.insertAtStart(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->null
        list.insertAtEnd(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->null
        list.insertAfter(7, 8);

        // Insert 9, before 8. So linked list becomes 1->7->9->8->6->4->null
        list.insertBefore(8, 9);

        // Insert 12, before 1. So linked list becomes 12->1->7->9->8->6->4->null
        list.insertBefore(1, 12);

        // Insert 10 at end. So linked list becomes 12->1->7->9->8->6->4->10->null
        list.insertAtEnd(10);

        // Insert 13 before 10. So linked list becomes
        // 12->1->7->9->8->6->4->13->10->null
        list.insertBefore(10, 13);

        // Remove 7. So linked list becomes
        // 12->1->9->8->6->4->13->10->null
        list.remove(7);

        // Remove 12. So linked list becomes
        // 1->9->8->6->4->13->10->null
        list.remove(12);

        // Remove 10. So linked list becomes
        // 1->9->8->6->4->13->null
        list.remove(10);
        list.print();

        list.printMiddle();

        // Reverse 13->4->6->8->9->1->null
        list.reverse();
        list.print();
    }
}
