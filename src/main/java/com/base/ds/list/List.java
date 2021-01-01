package com.base.ds.list;

import com.base.ds.nodes.Node;
import static com.base.utils.InputUtil.sysout;

public abstract class List {
    // Even though Node has prev,
    // for single linked list it will not be set
    // head of the list
    public Node head;

    public abstract void insertAtStart(int x);

    public abstract void insertBefore(int value, int x);

    public abstract void insertAfter(int value, int x);

    public abstract void insertAtEnd(int x);

    public abstract void remove(int x);

    public abstract void print();

    public abstract void reverse();

    public static Node getLinkedList(int[] arr) {
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

    public void print(String separator) {
        print(head, separator);
    }

    public static void print(Node head, String separator) {
        Node node = head;
        StringBuilder builder = new StringBuilder("");
        while (node != null) {
            builder.append(node.data).append(separator);
            node = node.next;
        }
        builder.append("null");
        System.out.println("\nLinked list \n" + builder);
    }

    public void printMiddle() {
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
}