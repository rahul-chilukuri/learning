package com.base.ds.queue;

@SuppressWarnings("unchecked")
public class Queue<T> {
    int front, rear, size;
    int capacity;
    Object[] array;

    Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new Object[this.capacity];
    }

    boolean isFull() {
        return this.capacity == this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue FULL...");
        } else {
            rear = (rear + 1) % capacity;
            array[rear] = item;
            size++;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty...");
            return (T) null;
        } else {
            T item = (T) array[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    T peek() {
        return front();
    }

    T front() {
        if (isEmpty()) {
            System.out.println("Queue empty...");
            return (T) null;
        } else {
            return (T) array[front];
        }
    }

    T rear() {
        if (isEmpty()) {
            System.out.println("Queue empty...");
            return (T) null;
        } else {
            return (T) array[rear];
        }
    }

    void printState() {
        System.out.println(String.format("front - %d, rear - %d, size - %d", front, rear, size));
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(10);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(10 * (i + 1));
        }

        // for (int i = 0; i < 10; i++) {
        // System.out.println("###############");
        // queue.printState();
        // queue.dequeue();
        // queue.printState();
        // queue.enqueue((i + 1) * 10);
        // queue.printState();
        // }

        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());
    }
}