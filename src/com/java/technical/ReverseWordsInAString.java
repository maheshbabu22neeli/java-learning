package com.java.technical;


public class ReverseWordsInAString {

    public static void main(String args[]) {

        String originalString = "I am working as a software engineer";

        String resultReverseString = getReverseWordsString(originalString);
        System.out.println("Result Reverse String = " + resultReverseString);
    }

    private static String getReverseWordsString(String originalString) {

        if (originalString == null || originalString.isEmpty()) {
            return null;
        }

        String[] stringArray = originalString.split(" ");

        StringBuilder resultString = new StringBuilder();

        for (int i = 0 ; i < stringArray.length ; i++) {
            resultString.append(new StringBuffer(stringArray[i]).reverse().append(" "));
        }

        return resultString.toString();
    }

}
