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
        Node slow = head, fast = head, prev = null, temp;

        // splitting this head list into two
        // one starts at the middle
        // the other one starts at middle and points backward
        while (fast != null) {
            if (fast.next == null) {
                slow = slow.next;
                break;
            }

            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (slow != null && prev != null) {
            if (slow.data != prev.data) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return slow == null && prev == null;
    }
}
