package com.base.sorting;

import com.base.utils.InputUtil;

/**
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 */
public class InsertionSort {
    public static void main(String[] args) {
        // int[] arr = InputUtil.getIntArray();
        int[] arr = new int[] { 14, 33, 27, 10, 35, 19, 42, 44 };

        InputUtil.print(arr);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // if temp was smaller than any of the elements before it
            // the above while loop would have set those elements in order
            // and finally insert temp in it's right position
            arr[j] = temp;
        }
        InputUtil.print(arr);
    }
}
