package com.sr.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

/**
 * Sort based on pivot
 * all elements to the right of pivot are greater than pivot
 * all elements to the left of pivot are less than pivot
 * Once pivot is placed appropriately, recursively quicksort
 * arrays to the left and right of pivot
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        InputUtil.print(arr);
        quickSort(arr,0, arr.length-1);
        InputUtil.print(arr);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = arr[getPIndex(left, right)];
        int p = partition(arr, left, right, pivot);
        quickSort(arr, left, p-1);
        quickSort(arr, p, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while(left < right) {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }

            if(left<=right) {
                InputUtil.swapInts(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static int getPIndex(int left, int right) {
        return (left+right)/2;
        //return left;
        //return right;
    }
}
