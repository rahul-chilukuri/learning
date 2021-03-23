package com.base.sorting;

import com.base.utils.InputUtil;

/**
 * Elements to the left are to be assumed sorted if elements on the right are
 * less than any of the elements on the left, swap until the right position is
 * achieved
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        arr = new int[] { 5, 1, 6, 2, 4, 3 };
        // arr = new int[] { 1, 2, 3, 4, 5, 6 };
        InputUtil.print(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    InputUtil.swapInts(arr, j, j + 1);
                }
            }
        }

        InputUtil.print(arr);
    }
}