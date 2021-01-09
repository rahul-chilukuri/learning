package com.base.ds.list;

import com.base.ds.nodes.Node;

public class CircularLinkedList extends DefaultList {

    public void insertAtStart(int x) {
        Node first = new Node(x, head);
        if (first.next == null) {
            first.next = first;
        } else {
            pointTailToHead(first);
        }
        head = first;
    }

    public void insertBefore(int value, int x) {
        assert head != null;
        if (head.val == value) {
            insertAtStart(x);
            return;
        }

        Node next, node = head;
        do {
            next = node.next;
            if (next.val == value) {
                Node temp = new Node(x, next);
                node.next = temp;
                break;
            }
            node = next;
        } while (node != head);
    }

    public void insertAfter(int value, int x) {
        assert head != null;
        Node node = head;
        do {
            if (node.val == value) {
                Node next = node.next;
                Node temp = new Node(x, next);
                node.next = temp;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void insertAtEnd(int x) {
        if (head == null) {
            insertAtStart(x);
            return;
        }

        Node node = head;
        while (node.next != head) {
            node = node.next;
        }
        node.next = new Node(x, head);
    }

    public void removeFirst() {
        Node node = head;
        Node first = node.next;
        while (node.next != head) {
            node = node.next;
        }
        node.next = first;
        head = first;
    }

    public void remove(int x) {
        assert head != null;
        if (head.val == x) {
            removeFirst();
            return;
        }
        Node node = head;
        while (node.next != head) {
            Node next = node.next;
            if (next.val == x) {
                node.next = next.next;
                break;
            }
            node = node.next;
        }
    }

    public void reverse() {
        assert head != null;
        Node next, prev = null, current = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);
        current.next = prev;
    }

    void pointTailToHead(Node node) {
        Node currentHead = node;
        Node prevHead = node.next;
        node = prevHead;
        while (node.next != prevHead) {
            node = node.next;
        }
        node.next = currentHead;
    }

    public void print() {
        printCircular();
    }

    public void printCircular() {
        printCircular(head, "-◙-");
    }

    public void print(String separator) {
        assert head != null;
        Node node = head;
        StringBuilder builder = new StringBuilder("");

        do {
            builder.append(node.val).append(separator);
            node = node.next;
        } while (!head.equals(node));
        builder.append(head.val);

        // while (node != null) {
        // builder.append(node.data).append(separator);
        // if (node.next == head) {
        // builder.append(head.data);
        // break;
        // }
        // node = node.next;
        // }

        System.out.println("\nLinked list \n" + builder);
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        List list = new CircularLinkedList();

        // Insert 6. So linked list becomes 6->6
        list.insertAtEnd(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->7
        list.insertAtStart(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->1
        list.insertAtStart(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->1
        list.insertAtEnd(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->1
        list.insertAfter(7, 8);

        // Insert 9, before 8. So linked list becomes 1->7->9->8->6->4->1
        list.insertBefore(8, 9);

        // Insert 12, before 1. So linked list becomes 12->1->7->9->8->6->4->12
        // list.print();
        list.insertBefore(1, 12);

        // Insert 10 at end. So linked list becomes 12->1->7->9->8->6->4->10->12
        list.insertAtEnd(10);

        // Insert 13 before 10. So linked list becomes
        // 12->1->7->9->8->6->4->13->10->12
        list.insertBefore(10, 13);

        // Remove 7. So linked list becomes
        // 12->1->9->8->6->4->13->10->12
        list.remove(7);

        // Remove 12. So linked list becomes
        // 1->9->8->6->4->13->10->1
        list.remove(12);

        // Remove 10. So linked list becomes
        // 1->9->8->6->4->13->1
        list.remove(10);
        list.print();

        // Reverse 1->13->4->6->8->9->1->1
        // by reversal, head wont change only the
        // direction of the list will change
        list.reverse();
        list.print();
    }
}