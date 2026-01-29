package com.java.technical;


import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAString {

    public static void main(String[] args) {

        String originalString = "I am working as a software engineer";

        String resultReverseString = getReverseWordsString(originalString);
        System.out.println("Result Reverse String = " + resultReverseString);
        // output : Result Reverse String = I ma gnikrow sa a erawtfos reenigne
    }

    private static String getReverseWordsString(String originalString) {

        if (originalString == null || originalString.isEmpty()) {
            return null;
        }

        String[] stringArray = originalString.split(" ");

        StringBuilder resultBuilder = new StringBuilder();

        /*for (int i = 0 ; i < stringArray.length ; i++) {
            resultBuilder.append(new StringBuffer(stringArray[i]).reverse().append(" "));
        }
        return resultBuilder.toString();*/

        return Arrays.stream(stringArray)
                .map(word -> new StringBuffer(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
