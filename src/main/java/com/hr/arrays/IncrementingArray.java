package com.hr.arrays;

import java.io.IOException;
import java.util.Arrays;

public class IncrementingArray {

    public static void main(String[] args) throws IOException {
        int[][] queries = new int[3][3];

        queries[0] = new int[] { 1, 5, 3 };
        queries[1] = new int[] { 4, 8, 7 };
        queries[2] = new int[] { 6, 9, 1 };
        System.out.println(arrayManipulation(10, 3, queries));
    }

    public static long arrayManipulation(int n, int m, int[][] queries) {
        int[] b = new int[n];
        int maxValue = 0;

        for (int i = 0; i < queries.length; i++) {
            int sIdx = queries[i][0];
            int eIdx = queries[i][1];
            int value = queries[i][2];

            b[sIdx] += value;
            if (eIdx + 1 < n) {
                b[eIdx + 1] -= value;
            }
            System.out.println(Arrays.toString(b));
        }

        int tmp = 0;
        for (int i = 0; i < b.length; i++) {
            tmp += b[i];
            if (maxValue < tmp) {
                maxValue = tmp;
            }
        }
        return maxValue;
    }
}
