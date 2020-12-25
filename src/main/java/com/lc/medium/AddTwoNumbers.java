package com.lc.medium;

import com.sr.ds.list.DefaultList;
import com.sr.ds.list.Node;

public class AddTwoNumbers extends DefaultList {

    public static void main(String[] args) {

        // least significant bit appearing at the front of the list
        Node l1 = getListNode(new int[] { 2, 4, 3 });
        Node l2 = getListNode(new int[] { 5, 6, 4 });

        Node sumNode = addTwoNumbersInReversedOrder(l1, l2);
        printNode(sumNode);

        // most significant bit appearing at the front of the list
        l1 = getListNode(new int[] { 5, 6, 3 });
        l2 = getListNode(new int[] { 9, 9, 8, 4, 2 });

        printNode(addTwoNumbersByPrependingZeroes(l1, l2));
        System.out.println("Without modification\n");
        printNode(addTwoNumbers(l1, l2));
    }

    static int getSize(Node node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("null\n");
    }

    static Node getListNode(int[] numbers) {
        Node head = new Node();
        Node node = head;
        for (int number : numbers) {
            Node temp = new Node(number);
            node.next = temp;
            node = temp;
        }
        return head.next;
    }

    static Node prependZeroes(Node node, int diff) {
        Node temp, head = node;
        while (diff > 0) {
            temp = new Node(0);
            temp.next = head;
            head = temp;
            diff--;
        }
        return head;
    }

    static Node checkAndSetHeadNodeForCarryOver(Node head) {
        int carry = head.data / 10;
        if (carry > 0) {
            head.data %= 10;
            head = new Node(carry, head);
        }
        return head;
    }

    static Node addTwoNumbers(Node n1, Node n2) {
        int s1 = getSize(n1);
        int s2 = getSize(n2);
        int diff = s1 - s2;
        return addTwoNodes(s1 > s2 ? n1 : n2, s1 > s2 ? n2 : n1, Math.abs(diff));
    }

    static Node addTwoNodes(Node bNode, Node sNode, int diff) {
        Node bigHead = bNode;
        int tempDiff = diff;

        while (tempDiff-- > 0) {
            bNode = bNode.next;
        }

        Node sameSizeSumNode = addSameSizeNodes(bNode, sNode);
        Node sumNode = propagateCarry(bigHead, sameSizeSumNode, diff);
        assert sumNode != null;

        // check if head digit is greater than 10
        return checkAndSetHeadNodeForCarryOver(sumNode);
    }

    static Node addSameSizeNodes(Node l1, Node l2) {
        Node node = null;

        //checking for null on either nodes is redundant
        //check on one should be enough since they are
        //of same size, but retaining those checks to be clear
        if (l1.next == null && l2.next == null) {
            node = new Node(l1.data + l2.data);
        } else {
            if (l1 != null && l2 != null) {
                node = addSameSizeNodes(l1.next, l2.next);
                int carry = node.data / 10;
                node.data %= 10;
                node = new Node(l1.data + l2.data + carry, node);
            }
        }
        return node;
    }

    static Node propagateCarry(Node bigNode, Node sameSizeSumNode, int diff) {
        assert diff > -1;
        int carry;
        if (diff == 0) {
            return sameSizeSumNode;
        } else if (diff == 1) {
            carry = sameSizeSumNode.data / 10;
            sameSizeSumNode.data %= 10;
            return new Node(carry + bigNode.data, sameSizeSumNode);
        } else {
            Node node = propagateCarry(bigNode.next, sameSizeSumNode, --diff);
            carry = node.data / 10;
            node.data %= 10;
            return new Node(carry + bigNode.data, node);
        }
    }

    static Node addTwoNumbersByPrependingZeroes(Node l1, Node l2) {
        printNode(l1);
        printNode(l2);
        assert l1 != null;
        assert l2 != null;
        int size1 = getSize(l1);
        int size2 = getSize(l2);

        int diff = size1 - size2;

        if (diff != 0) {
            Node big = diff > 0 ? l1 : l2;
            Node prependedSmall = prependZeroes(diff > 0 ? l2 : l1, Math.abs(diff));
            l1 = big;
            l2 = prependedSmall;
        }

        Node sumNode = addSameSizeNodes(l1, l2);
        assert sumNode != null;

        // check if head digit is greater than 10
        return checkAndSetHeadNodeForCarryOver(sumNode);
    }

    static Node addTwoNumbersInReversedOrder(Node l1, Node l2) {
        Node headPrev = new Node(0);
        Node curr = headPrev;
        int sum, carry = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? l2.data : (l2 == null ? l1.data : (l1.data + l2.data))) + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        curr.next = carry > 0 ? new Node(carry) : null;
        return headPrev.next;
    }
}
