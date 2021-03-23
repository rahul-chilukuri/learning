package com.base.ds.heap;

import com.base.utils.InputUtil;

public class HeapArrImpl {
    public static void main(String[] args) {
        int n = InputUtil.getRandomInt(15);
        int[] arr = InputUtil.getIntArray(n);
        InputUtil.print(arr);
        int swch = (int) Math.round(Math.random());
        if (swch == 0) {
            minHeap(arr);
        } else {
            maxHeap(arr);
        }
        InputUtil.print(arr);
    }

    public static void minHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            buildHeap(arr, i, false);
        }
        if (isMinHeap(arr, 0)) {
            System.out.print("Min HeapArrImpl -\tYes -\t");
            InputUtil.print(arr);
        }
    }

    public static void maxHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            buildHeap(arr, i, true);
        }
        if (isMaxHeap(arr, arr.length)) {
            System.out.print("Max HeapArrImpl -\tYes -\t");
            InputUtil.print(arr);
        }
    }

    private static void buildHeap(int[] arr, int i, boolean maxify) {
        heapify(arr, i, maxify);
    }

    private static void heapify(int[] arr, int pos, boolean maxify) {
        int parent = getParent(pos);
        while (parent >= 0) {
            boolean isSwapRequired = maxify ? arr[pos] > arr[parent] : arr[pos] < arr[parent];
            if (isSwapRequired) {
                InputUtil.swapInts(arr, pos, parent);
                pos = parent;
                parent = getParent(parent);
            } else {
                break;
            }
        }
    }

    private static int getParent(int pos) {
        if (pos > 0) {
            // return pos % 2 == 0 ? (pos - 1) / 2 : pos / 2;
            return (pos - 1) / 2;
        } else {
            return -1;
        }
    }

    /************************** Not my impl from here ****************************/
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

    public static boolean isMinHeap(int[] A, int i) {
        // if i is a leaf node, return true as every leaf node is a heap
        if (2 * i + 2 > A.length) {
            return true;
        }

        // if i is an internal node

        // recursively check if left child is heap
        boolean left = (A[i] <= A[2 * i + 1]) && isMinHeap(A, 2 * i + 1);

        // recursively check if right child is heap (to avoid array out
        // of bound, we first check if right child exists or not)
        boolean right = (2 * i + 2 == A.length) || (A[i] <= A[2 * i + 2] && isMinHeap(A, 2 * i + 2));

        // return true if both left and right child are heap
        return left && right;
    }

}
