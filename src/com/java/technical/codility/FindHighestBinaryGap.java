package com.java.technical.codility;

public class FindHighestBinaryGap {

    public static void main(String[] args) {

        FindHighestBinaryGap findHighestBinaryGap = new FindHighestBinaryGap();
        System.out.println(findHighestBinaryGap.solution(1041  ));
    }

    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int counter = 0;
        int maxCounter = 0;
        boolean started = false;

        // 10000010001
        for (int i =0; i < binaryString.length(); i++) {
            String character = binaryString.substring(i, i+1);
            if (character.equals("1")) {
                if (started) {
                    if (counter > maxCounter) {
                        maxCounter = counter;
                    }
                }
                started = true;
                counter = 0;
            }
            if (character.equals("0")) {
                counter++;
            }
        }
        return maxCounter;
    }

}
