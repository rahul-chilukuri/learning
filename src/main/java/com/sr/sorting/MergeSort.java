package com.sr.sorting;

import com.sr.utils.InputUtil;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = InputUtil.getIntArray();
        //int[] arr = {14,7,3,12,9,11,6,2,2,2};
        //int[] arr = {8, 7, 9, 7, 6, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr, new Integer[arr.length],0, arr.length-1);
        System.out.println(Arrays.toString(arr));
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

        if(start == mid) {
            if(arr[start] > arr[end]) {
                InputUtil.swapInts(arr, start, end);
            }
            return;
        }

        int rtStart=mid+1;
        int i=start, k=start, j = rtStart;
        while(i < rtStart) {
            if(j < end+1) {
                if(arr[i] < arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            } else {
                temp[k++] = arr[i++];
            }
        }

        while(j < end+1) {
            temp[k++] = arr[j++];
        }
        System.out.println(Arrays.toString(temp));
        i=k=start;
        while( i < end+1) {
            arr[i++]=temp[k++];
        }
    }
}