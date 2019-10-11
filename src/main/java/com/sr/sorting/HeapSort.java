package com.sr.sorting;

import com.sr.ds.Heap;
import com.sr.utils.InputUtil;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray(15);
        InputUtil.print(arr);
        if(Math.round(Math.random()) > 0) {
            sortDesc(arr);
        } else {
            sortAsc(arr);
        }

        InputUtil.print(arr);
    }

    private static void sortAsc(int[] arr) {
        int n = arr.length;
        Heap.maxHeap(arr);

        int i = n-1;
        while(i>-1) {
            InputUtil.swapInts(arr, 0, i);
            maxifyHeap(arr, 0, --i);
        }
    }

    private static void sortDesc(int[] arr) {
        int n = arr.length;
        Heap.minHeap(arr);

        int i = n-1;
        while(i>-1) {
            InputUtil.swapInts(arr, 0, i);
            minifyHeap(arr, 0, --i);
        }
    }

    private static void maxifyHeap(int[] arr, int p, int end) {
        heapify(arr, p, end, true);
    }

    private static void minifyHeap(int[] arr, int p, int end) {
        heapify(arr, p, end, false);
    }

    private static void heapify(int[] arr, int p, int end, boolean maxify) {
        int lc;
        lc = leftChildIndex(p);

        if(lc > end) {
            return;
        }

        int rc = rightChildIndex(p), parent = arr[p], leftChild = arr[lc];
        int rightChild, swapCandidate;
        boolean needSwap;
        if(maxify) {
            rightChild = rc > end? Integer.MIN_VALUE: arr[rc];
            swapCandidate= Math.max(leftChild, rightChild);
            needSwap = swapCandidate > parent;
        } else {
            rightChild = rc > end? Integer.MAX_VALUE: arr[rc];
            swapCandidate= Math.min(leftChild, rightChild);
            needSwap = swapCandidate < parent;
        }

        if(needSwap) {
            if(swapCandidate == leftChild) {
                InputUtil.swapInts(arr, lc, p);
                heapify(arr, lc, end, maxify);
            } else {
                InputUtil.swapInts(arr, rc, p);
                heapify(arr, rc, end, maxify);
            }
        }
    }

    public static int leftChildIndex(int pos) {
        return (2 * pos)+1;
    }

    public static int rightChildIndex(int pos) {
        return 2 * (pos + 1);
    }
}
