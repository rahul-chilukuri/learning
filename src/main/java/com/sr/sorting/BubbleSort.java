package com.sr.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

/**
 * Elements to the left are to be assumed sorted
 * if elements on the right are less than any of the
 * elements on the left, swap until the right position is achieved
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        System.out.println(Arrays.toString(arr));

        for(int k=0;k<arr.length;k++){
            for(int i=0, j=1; j < arr.length; i++,j++) {
                if(arr[j] < arr[i]) {
                    InputUtil.swapInts(arr, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}