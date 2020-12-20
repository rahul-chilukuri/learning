package com.lc.medium;

import java.util.Arrays;
import static com.sr.utils.InputUtil.sysexit;
import static com.sr.utils.InputUtil.sysout;

public class LongestSubstring {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        sysout(substrA("dvdf")); // vdf -> 3
        sysout(substrA("abcabcbadbcb")); // cbad -> 4
        sysout(substrA("abcabcbb")); // abc -> 3
        sysout(substrA("abcabcdabcde")); // acbde -> 5
        sysout(substrA("abcabcdaecbd")); // bcdae daecb -> 5
        sysout(substrA("abcabcd")); // abcd -> 4
        sysout(substrA("abcabc")); // abc -> 3
        sysout(substrA("pwwkew")); // wke -> 3
        sysout(substrA("bbbbb")); // b -> 1
        sysout(substrA(" "));
        sysout(substrA(""));
        sysout(System.currentTimeMillis() - s);
        sysexit();
    }

    public static int substrA(String s) {
        int[] charset = new int[128];
        Arrays.fill(charset, -1);
        int c = 0, i = 0, count = 0, max = 0, len = s.length(), idx = 0;

        while (i < len) {
            c = s.charAt(i);
            idx = charset[c];
            if (idx > -1) {
                max = Math.max(max, count);
                Arrays.fill(charset, -1);
                i = idx + 1;
                count = 0;
            } else {
                charset[c] = i++;
                count++;
            }
        }

        // if the last character was not encountered previously
        return Math.max(count, max);
    }

    static public int substrB(String s) {
        int[] count = new int[128];
        int start = 0, end = 0, max = 0, cur = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            count[c]++;
            cur++;
            while (count[c] > 1) {
                count[s.charAt(start)]--;
                start++;
                cur--;
            }
            max = Math.max(max, cur);
            end++;
        }
        return Math.max(max, cur);
    }

    // similar but shorted implementation to substrA
    public static int substrC(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
