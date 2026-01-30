package com.java.technical;

public class Palendrome {

    public static void main (String[] args) {

        // 12321
        // 0
        // 123
        int input = -12321;
        boolean isPalendrome = verifyPalendrome(input);
        System.out.println("the given number is palendrome "+ isPalendrome) ;

    }

    private static boolean verifyPalendrome(int input) {

        int originalInput = input;
        int reversed = 0;

        while (input > 0) {   // 12321
            int remainder = input % 10;    //1 2
            reversed = reversed * 10 + remainder; // 1 10 +2   // 12
            input = input / 10;  // 1232
        }

        return originalInput == reversed;
    }
}
