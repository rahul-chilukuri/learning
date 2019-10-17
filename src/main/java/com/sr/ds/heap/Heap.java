package com.sr.ds.heap;

import com.sr.utils.InputUtil;
import java.util.Arrays;

public class Heap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];
    private boolean isMaxHeap;

    Heap(boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
    }

    private boolean isMaxHeap() {
        return this.isMaxHeap;
    }

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
        while(pIdx > -1 && isMaxHeap()?items[idx]>items[pIdx]: items[idx]<items[pIdx]) {
            InputUtil.swapInts(items, idx, pIdx);
            idx = pIdx;
            pIdx = getParentIndex(pIdx);
        }
    }

    public void siftDown() {
        boolean isMax = isMaxHeap();
        int idx = 0;
        while(hasLeftChild(idx)) {
            int lIdx = getLeftChildIndex(idx);
            int rIdx = getRightChildIndex(idx);
            int sIdx;

            int lc = items[lIdx];
            int rc = isMax? rIdx < size? items[rIdx]:Integer.MIN_VALUE  :rIdx < size? items[rIdx]:Integer.MAX_VALUE;
            int sc = isMax? Math.max(lc,rc):Math.min(lc, rc);


            if(isMax? sc> items[idx]: sc < items[idx]) {
                sIdx = sc == lc? lIdx:rIdx;
                InputUtil.swapInts(items, sIdx, idx);
                idx = sIdx;
            } else {
                break;
            }
        }

        /*
        int[] arr= Arrays.copyOf(items,size);
        if (HeapArrImpl.isMinHeap(arr, 0)) {
            InputUtil.print("Min HeapArrImpl -\tYes", arr);
        } else if (HeapArrImpl.isMaxHeap(arr, size)) {
            InputUtil.print("Max HeapArrImpl -\tYes", arr);
        }
        */
    }

    public static void main(String[] args) {
        boolean isMaxHeap = Math.round(Math.random()) == 0 ? false:true;
        Heap heap = new Heap(isMaxHeap);

        int arrLength = 15;
        int[] arr = InputUtil.getIntArray(arrLength);
        InputUtil.print("Input Arr",arr);
        for(int i : arr) {
            heap.add(i);
        }

        InputUtil.print(isMaxHeap? "Max Heap ":"Min Heap ",Arrays.copyOf(heap.items, heap.size));

        //removing k elements from heap
        int len = (int) Math.round(arrLength*(Math.random()));
        int[] removed = new int[len];
        for(int j= 0; j< len;j++) {
            removed[j] = heap.poll();
        }

        InputUtil.print("Removed "+len+" elements",removed);
    }
}
