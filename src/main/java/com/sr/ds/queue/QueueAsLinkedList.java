package com.sr.ds.queue;

import com.sr.ds.nodes.Node;

public class QueueAsLinkedList {
    Node front;
    Node rear;

    boolean isEmpty() {
        return rear == null;
    }

    void enqueue(int item) {
        Node temp = new Node(item);

        if (rear == null) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
    }

    Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY");
            return null;
        } else {
            Node temp = front;
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
            }
            return temp.data;
        }
    }

    void print() {
        assert front != null && rear != null;
        Node node = front;
        StringBuilder builder = new StringBuilder("");
        while (node != null) {
            builder.append(node.data).append("->");
            node = node.next;
        }
        builder.append("null");
        System.out.println("Queue " + builder);
    }

    public static void main(String[] args) {
        QueueAsLinkedList queue = new QueueAsLinkedList();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(10 * (i + 1));
        }

        queue.print();
        // for (int i = 0; i < 10; i++) {
        // queue.dequeue();
        // }
        for (int i = 0; i < 10; i++) {
            System.out.println("###############");
            queue.print();
            queue.dequeue();
            queue.print();
            queue.enqueue((i + 1) * 3);
            queue.print();
        }

        queue.dequeue();
        queue.print();
    }
}
