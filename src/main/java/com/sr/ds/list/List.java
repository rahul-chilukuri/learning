package com.sr.ds.list;

import com.sr.ds.nodes.Node;
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

    Node getLinkedList(int[] arr) {
        Node head = new Node();
        Node node = head;
        Node temp;
        for (int i : arr) {
            temp = new Node(i);
            temp.next = node;
            node = temp;
        }
        return head.next;
    }

    void printCircular() {
        printCircular(head, "-◙-");
    }

    void printCircular(Node node, String separator) {
        assert node != null;
        StringBuilder builder = new StringBuilder("");

        do {
            builder.append(node.data).append(separator);
            node = node.next;
        } while (!head.equals(node));
        builder.append(head.data);
        System.out.println("\nLinked list \n" + builder);
    }

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
        return getLoopInNode() != null ? true : false;
    }

    Node getLoopInNode() {
        Node fast = head;
        Node slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return slow;
    }

    void detectAndRemoveLoop() {
        Node loop = getLoopInNode();
        if (loop == null) {
            return;
        }

        sysout("Loop node is " + loop.data);

        Node l1 = head;

        // l1 at head and l2 at loop node
        // if they move 1 step at a time,
        // they will eventually meet at start of cycle
        while (l1.next != loop.next) {
            l1 = l1.next;
            loop = loop.next;
        }

        loop.next = null;
    }

    Node getFirstNodeInCycle() {
        Node s = head, f = head;
        do {
            if (f == null || f.next == null) {
                return null;
            } else {
                f = f.next.next;
                s = s.next;
            }
        } while (s != f);

        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    Node getFirstIntersectionNode(Node h1, Node h2) {
        Node n1 = h1;
        Node n2 = h2;

        while (n1 != n2) {
            n1 = n1 == null ? n2 : n1.next;
            n2 = n2 == null ? n1 : n2.next;
        }
        return n1;
    }

    /*
     * Constraints on this linked list: not a loop. n <= size of the list
     */
    Node removeNthNodeFromEnd(Node head, int n) {
        if (n < 1 || head == null) {
            return head;
        }

        // n cannot be greater than the size of the list
        // so can increment n2 until n > 1 as n2 is already at head
        // To get nth node from last, set a node(n2) at n distance from beginning
        // have another node(n1) start from head and move both n1 and n2 simultaenously
        // When n2 is at last node, n1 is the nth node from end.
        Node n2 = head;
        while (n-- > 1) {
            n2 = n2.next;
        }

        // end of list reached and intended
        // node to be removed is the first one
        if (n2.next == null) {
            return head.next;
        } else {

            //else traverse n2 until the next element is null
            Node prev, n1 = head;
            do {
                prev = n1;
                n1 = n1.next;
                n2 = n2.next;
            } while (n2.next != null);

            prev.next = n1.next;
            return head;
        }
    }
}