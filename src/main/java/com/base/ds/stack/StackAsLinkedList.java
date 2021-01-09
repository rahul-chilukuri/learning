package com.base.ds.stack;

import com.base.ds.nodes.Node;

public class StackAsLinkedList {
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newHead = new Node(data, head);
            head = newHead;
        }
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        } else {
            Node poppedNode = head;
            head = head.next;
            return poppedNode.val;
        }
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        } else {
            return head.val;
        }
    }

    public static void main(String[] args) {
        StackAsLinkedList stack = new StackAsLinkedList();
        System.out.println("is stack empty ->" + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("is stack empty ->" + stack.isEmpty());
        System.out.println(stack.pop() + " Popped from stack");
        System.out.println(stack.pop() + " Popped from stack");
        System.out.println(stack.pop() + " Popped from stack");
        System.out.println("is stack empty ->" + stack.isEmpty());
        System.out.println(stack.pop());
    }
}