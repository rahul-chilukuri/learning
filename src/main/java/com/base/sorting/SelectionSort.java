package com.base.sorting;

import com.base.utils.InputUtil;

/**
 * Get minimum element on each pass and put in it's place
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        InputUtil.print(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                InputUtil.swapInts(arr, i, min);
            }
        }

        InputUtil.print(arr);
    }
}
