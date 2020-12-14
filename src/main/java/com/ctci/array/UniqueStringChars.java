package com.ctci.array;

import java.math.BigInteger;
import java.util.Hashtable;

public class UniqueStringChars {
    public static void main(String[] args) {
        System.out.println(Integer.toString((int) (Math.random() * 100), 2));

        String[] gStrings = { "abcdABCDf", "abcdABCD%f", "abcdABCD%fa", "abcdABCD%f%" };
        for (String gString : gStrings) {
            System.out.println(String.format("%s uniq? - %b", gString, uniqueCharSet(gString)));
        }
    }

    /**
     * // O(n) O(1) space Better solution than official Interesting application of
     * assigning ascii code as an array index Each character iterated is put in the
     * boolean array The second time a character is parsed, checked against boolean
     * array
     * 
     * @param s
     * @return boolean
     */
    static boolean uniqueCharSet(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
        }
        return true;
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 32768) {
            return false;
        }
        BigInteger checker = BigInteger.ZERO;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (checker.testBit(val))
                return false;
            checker = checker.setBit(val);
        }
        // none of the characters has been seen more than once.
        return true;
    }

    /**
     * Lot of assumptions ctci solution assumes this is only about lowercase numbers
     * Java, char's are Unicode, and 2-byte values so there are 32768 values Bitmap
     * useful to set bits for any desired operation. Say, to mark a particular bit
     * is set Unique characters assumes there are 26 characters and it takes 32 bit
     * int as bitmap to be set If any of the character is visited, that particular
     * character's position is set in bitmap If the same character appears one more
     * time, the bitmap is checked to see if that bit is set If not set all char's
     * unique
     */
    static boolean ctciSolution(String str) {
        // short circuit - supposed to imply that
        // there are no more than 256 different characters.
        // this is broken, because in Java, char's are Unicode,
        // and 2-byte values so there are 32768 values
        // (or so - technically not all 32768 are valid chars)
        if (str.length() > 256) {
            return false;
        }
        // checker is used as a bitmap to indicate which characters
        // have been seen already
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // set val to be the difference between the char at i and 'a'
            // unicode 'a' is 97
            // if you have an upper-case letter e.g. 'A' you will get a
            // negative 'val' which is illegal
            int val = str.charAt(i) - 'a';
            // if this lowercase letter has been seen before, then
            // the corresponding bit in checker will have been set and
            // we can exit immediately.
            if ((checker & (1 << val)) > 0)
                return false;
            // set the bit to indicate we have now seen the letter.
            checker |= (1 << val);
        }
        // none of the characters has been seen more than once.
        return true;
    }

    // O(n^2)
    static boolean uniqueSubstr(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println("-->" + (1 << (int) (str.charAt(i) - 'a')));
            if (str.indexOf(str.charAt(i), i + 1) > 0) {
                return false;
            }
        }
        return true;
    }

    // O(n) but with O(n) space
    static boolean uniqueWithHashtable(String str) {
        Hashtable<Character, String> uniq = new Hashtable<>();
        for (int i = 0; i < str.length(); i++) {
            if (uniq.containsKey(str.charAt(i))) {
                return false;
            } else {
                uniq.put(str.charAt(i), "");
            }
        }
        return true;
    }
}
