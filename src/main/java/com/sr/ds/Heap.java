package com.sr.ds;

import com.sr.utils.InputUtil;

public class Heap {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray(31);
        InputUtil.print(arr);
        int swch = (int) Math.round(Math.random());
        if(swch == 0) {
            minHeap(arr);
        } else {
            maxHeap(arr);
        }
        InputUtil.print(arr);
    }

    public static void minHeap(int[] arr) {
        InputUtil.print("Min Heap");
        heapify(arr, false);
        if (isMinHeap(arr, 0)) {
            System.out.println("Yes");
        }
    }

    public static void maxHeap(int[] arr) {
        InputUtil.print("Max Heap");
        heapify(arr, true);
        if (isMaxHeap(arr, arr.length)) {
            System.out.println("Yes");
        }
    }

    private static void heapify(int[] arr, boolean maxify) {
        int p, j;
        for(int i = 1; i < arr.length;i++) {
            j = i;
            p = parent(j);
            while(p >=0) {
                boolean cond = maxify ? arr[j] > arr[p]: arr[j] < arr[p];
                if(cond) {
                    InputUtil.swapInts(arr, j, p);
                    j = p;
                    p = parent(p);
                }  else {
                    break;
                }
            }
        }

    }

    private static int parent(int pos) {
        if (pos > 0) {
            return pos % 2 == 0 ? (pos - 1) / 2 : pos / 2;
        } else {
            return -1;
        }
    }

    private static int leftChild(int pos) {
        return (2 * pos);
    }

    private static int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    static boolean isMaxHeap(int arr[], int n) {
        // Start from root and go till the last internal
        // node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            // If right child is greater, return false
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMinHeap(int[] A, int i)
    {
        // if i is a leaf node, return true as every leaf node is a heap
        if (2*i + 2 > A.length) {
            return true;
        }

        // if i is an internal node

        // recursively check if left child is heap
        boolean left = (A[i] <= A[2*i + 1]) && isMinHeap(A, 2*i + 1);

        // recursively check if right child is heap (to avoid array out
        // of bound, we first check if right child exists or not)
        boolean right = (2*i + 2 == A.length) ||
                (A[i] <= A[2*i + 2] && isMinHeap(A, 2*i + 2));

        // return true if both left and right child are heap
        return left && right;
    }

}
