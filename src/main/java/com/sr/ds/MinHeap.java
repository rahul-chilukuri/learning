package com.sr.ds;

import com.sr.utils.InputUtil;
import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];

    public int getParentIndex(int index) {
        return (index-1)/2;
    }
    public int getLeftChildIndex(int index) {
        return 2*index+1;
    }
    public int getRightChildIndex(int index) {
        return 2*(index+1);
    }
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public void ensureExtraCapacity() {
        if(size == capacity) {
            int newCapacity = capacity*2;
            items = Arrays.copyOf(items, newCapacity);
            capacity = newCapacity;
        }
    }

    public int peek() {
        if(size == 0)
            throw new IllegalStateException();

        return items[0];
    }

    public int poll() {
        if(size == 0)
            throw new IllegalStateException();

        int item = items[0];
        items[0] = items[size-1];
        size--;

        siftDown();

        return item;
    }

    public void add(int entry) {
        ensureExtraCapacity();
        items[size] = entry;
        size++;
        siftUp();
    }

    public void siftUp() {
        int idx = size - 1;
        int pIdx = getParentIndex(idx);
        while(pIdx > -1 && items[idx]<items[pIdx]) {
            InputUtil.swapInts(items, idx, pIdx);
            idx = pIdx;
            pIdx = getParentIndex(pIdx);
        }
    }

    public void siftDown() {
        int idx = 0;
        while(hasLeftChild(idx)) {
            int lIdx = getLeftChildIndex(idx);
            int rIdx = getRightChildIndex(idx);
            int sIdx;

            int lc = items[lIdx];
            int rc = rIdx < size? items[rIdx]:Integer.MAX_VALUE;
            int sc = Math.min(lc, rc);

            if(sc < items[idx]) {
                sIdx = sc == lc? lIdx:rIdx;
                InputUtil.swapInts(items, sIdx, idx);
            } else {
                break;
            }

            idx = sIdx;
        }
        /*
        int[] arr= Arrays.copyOf(items,size);
        if (Heap.isMinHeap(arr, 0)) {
            InputUtil.print("Min Heap -\tYes", arr);
        }
        */
    }

    public static void main(String[] args) {
        MinHeap minHeap  = new MinHeap();
        int[] arr = InputUtil.getIntArray(15);
        InputUtil.print(arr);
        for(int i : arr) {
            minHeap.add(i);
        }

        InputUtil.print("min heap",Arrays.copyOf(minHeap.items,minHeap.size));

        //removing k min elements from min heap
        int len = 10;
        int[] minElements = new int[len];
        for(int j= 0; j< len;j++) {
            minElements[j] = minHeap.poll();
        }

        InputUtil.print("min elements",minElements);
    }
}
