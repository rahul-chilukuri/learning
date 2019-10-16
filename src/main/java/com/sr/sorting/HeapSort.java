package com.sr.sorting;

import com.sr.ds.Heap;
import com.sr.utils.InputUtil;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray(31);
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
            heapify(arr, 0, --i, true);
        }
    }

    private static void sortDesc(int[] arr) {
        int n = arr.length;
        Heap.minHeap(arr);

        int i = n-1;
        while(i>-1) {
            InputUtil.swapInts(arr, 0, i);
            heapify(arr, 0, --i, false);
        }
    }

    private static void heapify(int[] arr, int p, int end, boolean maxify) {
        int lc = leftChildIndex(p);

        if(lc > end) {
            return;
        }

        int rc = rightChildIndex(p), parent = arr[p], leftChild = arr[lc];
        int rightChild, swapChild;
        boolean needSwap;
        if(maxify) {
            rightChild = rc > end? Integer.MIN_VALUE: arr[rc];
            swapChild= Math.max(leftChild, rightChild);
            needSwap = swapChild > parent;
        } else {
            rightChild = rc > end? Integer.MAX_VALUE: arr[rc];
            swapChild= Math.min(leftChild, rightChild);
            needSwap = swapChild < parent;
        }

        if(needSwap) {
            int swapIndex = swapChild == leftChild ? lc: rc;
            InputUtil.swapInts(arr, swapIndex, p);
            heapify(arr, swapIndex, end, maxify);
        }
    }

    public static int leftChildIndex(int pos) {
        return (2 * pos)+1;
    }

    public static int rightChildIndex(int pos) {
        return 2 * (pos + 1);
    }
}
