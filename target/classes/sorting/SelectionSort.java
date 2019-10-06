package com.sr.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

/**
 * Get minimum element on each pass and put in it's place
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        System.out.println(Arrays.toString(arr));

        for(int i = 0 ; i < arr.length-1;i++) {
            int min = i;
            for(int j=i+1; j < arr.length;j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            if(min !=i) {
                InputUtil.swapInts(arr, i, min);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
