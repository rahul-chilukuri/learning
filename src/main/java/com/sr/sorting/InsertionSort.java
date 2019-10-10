package com.sr.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

/**
 * Elements to the left are to be assumed sorted
 * if elements on the right are less than any of the
 * elements on the left, swap until the right position is achieved
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        InputUtil.print(arr);

        for(int i=0; i < arr.length-1;i++) {
            for(int j=i+1; j < arr.length; j++) {
                if( (i < j && arr[j] < arr[i]) || ( i > j && arr[j] > arr[i])) {
                    InputUtil.swapInts(arr, i , j);
                    InputUtil.print(arr);
                }
            }
        }

        InputUtil.print(arr);
    }



    public static void sort(Integer[] arr){
        for(int i=0; i< arr.length;i++) {
            int temp = arr[i];
            int j = i;
            while(j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] =temp;
        }
    }
}
