package com.lc.easy;

public class ReverseInteger {

    public static void main(String[] args) {
        sysout(Integer.MIN_VALUE);
        sysout(Integer.MAX_VALUE);
        // System.exit(0);
        sysout(reverse(-9));
        sysout(reverse(0));
        sysout(reverse(9));
        sysout(reverse(-123));
        sysout(reverse(3023));
        sysout(reverse(3203));
        sysout(reverse(3270));
        sysout(reverse(7230));
        sysout(reverse(327));

    }

    static void sysout(int r) {
        System.out.println("r => " + r);
    }

    public static int reverse(int x) {
        System.out.println("x->" + x);

        int maxBy10 = Integer.MAX_VALUE / 10;
        int minBy10 = Integer.MIN_VALUE / 10;

        int rev = 0;
        int rem = 0;
        while (x != 0) {
            rem = x % 10;
            x /= 10;
            if (rev > maxBy10 || (rev == maxBy10 && rem > 7) || rev < minBy10 || (rev == minBy10 && rem < -8)) {
                return 0;
            } else {
                rev = rem + rev * 10;
            }
        }
        return rev;
    }
}