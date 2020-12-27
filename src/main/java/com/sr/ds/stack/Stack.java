package com.sr.ds.stack;

@SuppressWarnings("unchecked")
public class Stack<T> {
    int top;
    static final int MAX_SIZE = 100;
    Object[] array = new Object[MAX_SIZE];

    Stack() {
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public T peek() {
        if (top < 0) {
            System.out.println("Stack underflow..");
            return (T) null;
        } else {
            return (T) array[top];
        }
    }

    public T pop() {
        if (top < 0) {
            System.out.println("Stack underflow..");
            return (T) null;
        } else {
            T popped = (T) array[top];
            array[top--] = null;
            return popped;
        }
    }

    public void push(T entry) {
        if (top > MAX_SIZE - 2) {
            System.out.println("Stack Overflow..");
        } else {
            array[++top] = entry;
            // System.out.println(entry + " pushed into stack");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        System.out.println("is stack empty ->" + s.isEmpty());
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("is stack empty ->" + s.isEmpty());
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("is stack empty ->" + s.isEmpty());
        System.out.println(s.pop());
    }
}
