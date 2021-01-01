package com.base.ds.queue;

import com.base.ds.nodes.Node;

public class CircularQueue {
    Node front, rear;

    boolean isEmpty() {
        return rear == null;
    }

    void enqueue(int item) {
        Node node = new Node(item);
        if (rear == null) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        rear.next = front;
    }

    Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY..");
            return null;
        } else {
            Node temp = front;
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
                rear.next = front;
            }
            return temp.data;
        }
    }

    void displayQueue() {
        assert front != null && rear != null;
        Node node = front;
        StringBuilder builder = new StringBuilder("");
        Node next;
        do {
            builder.append(node.data).append("->");
            next = node.next;
            node = next;
        } while (next != front);

        builder.append(front.data);
        System.out.println("Queue " + builder);
    }

    public static void main(String[] args) {
        // Initialising new object of
        // CircularQueue class.
        CircularQueue q = new CircularQueue();

        q.enqueue(14);
        q.displayQueue();
        q.enqueue(22);
        q.enqueue(13);
        q.enqueue(-6);

        q.displayQueue();
        System.out.println("Dequeued -> " + q.dequeue());
        System.out.println("Dequeued -> " + q.dequeue());
        q.displayQueue();

        q.enqueue(9);
        q.enqueue(20);
        q.enqueue(5);
        q.enqueue(21);
        q.displayQueue();
    }
}