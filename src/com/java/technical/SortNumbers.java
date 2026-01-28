package com.java.technical;

import java.util.Arrays;

public class SortNumbers {

    public static void main (String args[]) {

        int[] inputArray = {12, 44, 55, 13, 23, 56};

        System.out.println("===========Ascending Order=================");
        // Ascending Order
        Arrays.sort(inputArray);
        Arrays.stream(inputArray)
                .forEach(number -> System.out.println(number));

        System.out.println("===========Descending Order=================");
        // Descending Order
        int[] outputArray = getSortedNumbers(inputArray);
        Arrays.stream(outputArray)
                .forEach(number -> System.out.println(number));

        Arrays.sort(inputArray);

    }

    private static int[] getSortedNumbers(int[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j < inputArray.length; j++) {
                int highest = inputArray[i];               // assuming the first number in every iteration is the highest number
                if (highest < inputArray[j]) {             // checking the condition here
                    inputArray[i] = inputArray[j];         // swap the number if condition satisfies
                    inputArray[j] = highest;
                }
            }
        }
        return inputArray;
    }
}
