package com.base.utils;

public class BitUtils {
    public static int add(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            // System.out.println(String.format("n1 %d, n2 %d", n1, n2));
            int tempSum = n1 ^ n2;
            int carry = (n1 & n2) << 1;
            // System.out.println(String.format("tempSum %d, carry %d", tempSum, carry));
            return add(tempSum, carry);
        }
    }

    public static void main(String[] args) {
        InputUtil.print(String.format("add(123, 13)                 => " + add(123, 13)));
        InputUtil.print(String.format("checkKthBitSet(5, 3)         => " + checkKthBitSet(5, 3)));
        InputUtil.print(String.format("checkKthBitSet(5, 2)         => " + checkKthBitSet(5, 2)));
        InputUtil.print(String.format("checkKthBitSet(5, 1)         => " + checkKthBitSet(5, 1)));
        InputUtil.print(String.format("setKthBit(5, 2)              => " + setKthBit(5, 2)));
        InputUtil.print(String.format("clearKthBit(5, 3)            => " + clearKthBit(5, 3)));
        InputUtil.print(String.format("toggleKthBit(5, 1)           => " + toggleKthBit(5, 1)));
        InputUtil.print(String.format("turnOffRightMostSetBit(5)    => " + turnOffRightMostSetBit(5)));
        InputUtil.print(String.format("isPowerOf2(5)                => " + isPowerOf2(5)));
        InputUtil.print(String.format("isPowerOf2(8)                => " + isPowerOf2(8)));
        InputUtil.print(String.format("isEven(8)                    => " + isEven(8)));
        InputUtil.print(String.format("isEven(7)                    => " + isEven(7)));

        // TODO need to test
        InputUtil.print(String.format("isolateRightMostZeroBit(5)   => " + isolateRightMostZeroBit(5)));
        InputUtil.print(String.format("isolateRightMostZeroBit(4)   => " + isolateRightMostZeroBit(4)));
    }

    public static boolean checkKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) > 0;
    }

    public static int setKthBit(int n, int k) {
        return (n | (1 << (k - 1)));
    }

    public static int clearKthBit(int n, int k) {
        return (n & ~(1 << (k - 1)));
    }

    public static int toggleKthBit(int n, int k) {
        return (n ^ (1 << (k - 1)));
    }

    public static int turnOffRightMostSetBit(int n) {
        return n & (n - 1);
    }

    public static int isolateRightMostZeroBit(int n) {
        return -n & n;
    }

    public static boolean isPowerOf2(int n) {
        return turnOffRightMostSetBit(n) == 0;
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
