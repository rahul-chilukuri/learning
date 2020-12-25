package com.sr.ds.list;

import static com.sr.utils.InputUtil.sysout;

public abstract class List {
    // Even though Node has prev,
    // for single linked list it will not be set
    // head of the list
    Node head;

    abstract void insertAtStart(int x);

    abstract void insertBefore(int value, int x);

    abstract void insertAfter(int value, int x);

    abstract void insertAtEnd(int x);

    abstract void remove(int x);

    abstract void print();

    abstract void reverse();

    void print(String separator) {
        print(head, separator);
    }

    void print(Node head, String separator) {
        Node node = head;
        StringBuilder builder = new StringBuilder("");
        while (node != null) {
            builder.append(node.data).append(separator);
            node = node.next;
        }
        builder.append("null");
        System.out.println("\nLinked list \n" + builder);
    }

    void printMiddle() {
        assert head != null;
        Node slow = head;
        Node fast = slow.next;

        int oneXCount = 1;
        int totalCount = fast == null ? 1 : 2;

        while (fast != null) {
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
                totalCount += (fast == null ? 1 : 2);
                slow = slow.next;
                oneXCount++;
            }
        }

        if (totalCount % 2 == 0) {
            sysout(String.format("\nMiddle element(s) are %d,%d with position %d & %d", slow.data, slow.next.data,
                    oneXCount, oneXCount + 1));
        } else {
            sysout(String.format("\nMiddle element(s) are %d with position %d", slow.data, oneXCount));
        }
    }

    boolean isLoop() {
        return getLoopInNode(head) == null ? false : true;
    }

    Node getLoopInNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                sysout(fast.data);
                return fast;
            }
        }
        return null;
    }

    void detectAndRemoveLoop() {
        removeLoop(getLoopInNode(head));
    }

    void removeLoop(Node loop) {
        if (loop == null) {
            return;
        }

        Node l1 = head;
        Node l2 = loop;

        while (true) {
            while (l2.next != loop && l2.next != head) {
                l2 = l2.next;
            }

            if (l2.next == l1) {
                break;
            }

            l1 = l1.next;
        }
        l2.next = null;
    }
}