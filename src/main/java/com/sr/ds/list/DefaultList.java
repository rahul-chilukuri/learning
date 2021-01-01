package com.sr.ds.list;

import com.sr.ds.nodes.Node;

public class DefaultList extends List {
    void insertAtStart(int x) {
    }

    void insertBefore(int value, int x) {
    }

    void insertAfter(int value, int x) {
    }

    void insertAtEnd(int x) {
    }

    void remove(int x) {
    }

    void print() {
    }

    void reverse() {
    }

    Node getLinkedList(int[] arr) {
        Node dummy = new Node();
        Node node = dummy;
        Node temp;
        for (int i : arr) {
            temp = new Node(i);
            node.next = temp;
            node = temp;
        }
        return dummy.next;
    }

    Node removeAll(Node head, int value) {
        Node dummy = new Node(-1, head);
        Node prev = dummy;
        Node node = dummy.next;

        while (node != null) {
            if (node.data == value) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = prev.next;
        }
        return dummy.next;
    }

    Node oddEvenList(Node head) {
        Node nextOdd, odd = head, evenStart = head == null ? null : head.next, even = evenStart;

        while (even != null && even.next != null) {
            nextOdd = even.next;
            odd.next = nextOdd;
            even.next = nextOdd.next;
            nextOdd.next = evenStart;

            odd = nextOdd;
            even = even.next;
        }
        return head;
    }

    boolean isPalindrome(Node head) {
        if (head == null)
            return true;

        Node h1 = head, temp = new Node(-1,head), h2 = temp;

        // set h2 to middle node
        while (temp != null && temp.next != null) {
            h2 = h2.next;
            temp = temp.next.next;
        }

        // if only one element, consider it a palindrome
        if (h2 == null)
            return true;

        // reverse h2
        Node next, prev = null;
        temp = h2.next == null ? h2 : h2.next;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        h2 = prev;

        while (h2 != null && h1 != null) {
            if (h1.data != h2.data) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
}
