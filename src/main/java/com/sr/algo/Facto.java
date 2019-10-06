package com.sr.algo;

import com.sr.utils.InputUtil;

public class Facto {
    public static void main(String[] args) {
        int n = InputUtil.getRandomInt(10);

        System.out.println(" n  ==> "+n);
        System.out.println("it  ==> "+iterative(n));
        System.out.println("rc  ==> "+recursive(n));
        System.out.println("rcm ==> "+recursiveM(n));
    }

    private static long iterative(int n) {
        long temp=1;
        for(int i=1;i<n+1;i++) {
            temp*=i;
        }
        return temp;
    }

    private static long recursive(int n) {
        if(n <=1) {
            return 1;
        } else {
            return n*recursive(n-1);
        }
    }

    private static long recursiveM(int n) {
        long[] memo = new long[n+1];
        memo[0] = 1;
        memo[1] = 1;
        return recursiveMemo(n, memo);
    }

    private static long recursiveMemo(int n, long[] memo) {
        if(n <= 1) {
            return 1;
        } else {
            if(memo[n] == 0) {
                memo[n] = n*(recursiveMemo(n-1, memo));
            }
            return memo[n];
        }
    }
}
