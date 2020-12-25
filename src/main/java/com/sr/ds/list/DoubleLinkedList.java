package com.sr.ds.list;

public class DoubleLinkedList extends List {

    public void insertAtStart(int x) {
        Node newNode = new Node(x, head);

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAfter(int value, int x) {
        assert head != null;
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                Node next = node.next;

                Node newNode = new Node(node, x, next);
                next.prev = newNode;
                node.next = newNode;
                break;
            }
            node = node.next;
        }
    }

    public void insertBefore(int value, int x) {
        assert head != null;
        Node node = head;

        while (node != null) {
            if (node.data == value) {
                Node prev = node.prev;
                Node newNode = new Node(prev, x, node);

                if (prev == null) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
                node.prev = newNode;

                break;
            }
            node = node.next;
        }
    }

    public void insertAtEnd(int x) {
        Node node = head;
        if (node == null) {
            head = new Node(x);
            return;
        }
        while (node.next != null) {
            node = node.next;
        }

        Node newNode = new Node(node, x);
        node.next = newNode;
    }

    public void remove(int value) {
        Node node = head;

        while (node != null) {
            if (node.data == value) {
                Node prev = node.prev;
                Node next = node.next;

                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }

                if (next != null) {
                    next.prev = prev;
                }

                break;
            }
            node = node.next;
        }
    }

    void reverse() {
        Node prev = null, next, current = head;
        while (current != null) {
            prev = current.prev;
            next = current.next;

            current.next = prev;
            current.prev = next;

            prev = current;
            current = next;
        }

        head = prev;
    }

    public void print() {
        this.print("<->");
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        List list = new DoubleLinkedList();

        // Insert 6. So linked list becomes 6<->null
        list.insertAtEnd(6);

        // Insert 7 at the beginning. So linked list becomes 7<->6<->null
        list.insertAtStart(7);

        // Insert 1 at the beginning. So linked list becomes 1<->7<->6<->null
        list.insertAtStart(1);

        // Insert 4 at the end. So linked list becomes 1<->7<->6<->4<->null
        list.insertAtEnd(4);

        // Insert 8, after 7. So linked list becomes 1<->7<->8<->6<->4<->null
        list.insertAfter(7, 8);

        // Insert 9, before 8. So linked list becomes 1<->7<->9<->8<->6<->4<->null
        list.insertBefore(8, 9);

        // Insert 12, before 1. So linked list becomes 12<->1<->7<->9<->8<->6<->4<->null
        list.insertBefore(1, 12);

        // Insert 10 at end. So linked list becomes
        // 12<->1<->7<->9<->8<->6<->4<->10<->null
        list.insertAtEnd(10);

        // Insert 13 before 10. So linked list becomes
        // 12<->1<->7<->9<->8<->6<->4<->13<->10<->null
        list.insertBefore(10, 13);

        // Remove 7. So linked list becomes
        // 12<->1<->9<->8<->6<->4<->13<->10<->null
        list.remove(7);

        // Remove 12. So linked list becomes
        // 1<->9<->8<->6<->4<->13<->10<->null
        list.remove(12);

        // Remove 12. So linked list becomes
        // 1<->9<->8<->6<->4<->13<->null
        list.remove(10);
        list.print();

        // Reverse 13<->4<->6<->8<->9<->1<->null
        list.reverse();
        list.print();
    }
}