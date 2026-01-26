package com.java.technical;

public class FindFirstNonRepeatingCharacter {

    public static void main(String args[]) {
        //String input = "cccbbdaabcbbccddeff";                    // result d;
        String input = "cccbbddaagcbbccddeff";                    // result g;
        //String input = "cbdaabcbbccddeff";                    // result c;

        if (input == null || input.isBlank()) {
            System.out.println("Input length is null or empty");
            return;
        }

        char nonRepeatingResultCharacter = getFirstNonRepeatingCharacter(input);
        System.out.println("Non Repeating Character: " + nonRepeatingResultCharacter);
    }

    private static char getFirstNonRepeatingCharacter(String input) {

        char[] inputCharArray = input.toCharArray();

        Character newChar = null;       // To identify the new character everytime
        boolean isCharChanged = false;  // Flag when ever there is a change in character
        char resultChar = 0;            // Result character if found

        for (int i=0; i < inputCharArray.length; i++) {
            if (newChar == null) {
                newChar = input.charAt(i);              // assign the first character to newChar
            } else {
                Character nextChar = input.charAt(i);   // Get Next character
                if (nextChar.equals(newChar)) {         // If equal, all good and no change in newChar
                    isCharChanged = false;
                } else if (!newChar.equals(nextChar) && !isCharChanged) {

                    // If first two characters are not same, which means first letter is not repeating character
                    if (i == 1) {
                        resultChar = newChar.charValue();
                        break;
                    }

                    // If not equal, which means newChar changed and need update isCharChanged = true
                    // And assign the nextChar to newChar
                    newChar = nextChar;
                    isCharChanged = true;
                    System.out.println("newChar Character changed to = " + newChar);
                } else if (!newChar.equals(nextChar) && isCharChanged) {
                    // If newChar and nextChar ane not equal and flag is true, then read the newChar and break the loop.
                    resultChar = newChar.charValue();
                    break;
                }
            }

        }
        return resultChar;
    }
}
