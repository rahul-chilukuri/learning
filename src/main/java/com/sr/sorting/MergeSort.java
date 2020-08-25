package com.sr.sorting;

import com.sr.utils.InputUtil;

import java.util.Arrays;

/**
 * MergeSort works by halving the arrays and doing a recursive sort on
 * those halves and merging them
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        InputUtil.print(arr);
        sort(arr, new Integer[arr.length],0, arr.length-1);
        InputUtil.print(arr);
    }

    public static void sort(int[] arr, Integer[] temp, int start, int end) {

        if( start >= end ) {
            return;
        }

        int mid = (start+end)/2;
        sort(arr, temp, start, mid);
        sort(arr, temp,mid+1, end);
        merge(arr, temp, start, mid, end);
    }
    
    public static void merge(int[] arr, Integer[] temp, int start, int mid, int end) {
        int rtStart=mid+1;
        int i=start, k=start, j = rtStart;

        //traverse from start of left half until the start of the right half
        //compare each element in both halves and add the elements
        //in sort order in temp array
        while(i < rtStart) {
            if(j <= end) {
                if(arr[i] < arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            } else {
                //adds remaining left half elements to temp
                temp[k++] = arr[i++];
            }
        }

        //add any remaining right half elements to temp
        while(j <= end) {
            temp[k++] = arr[j++];
        }
        System.out.println("-----------"+Arrays.toString(temp));
        i=k=start;
        while( i <= end) {
            arr[i++]=temp[k++];
        }
    }
}