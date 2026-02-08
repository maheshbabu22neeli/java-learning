package com.java.technical.codility;

import java.util.*;

public class CodilityFindIndexAndPositionOfString {

    //ex: s = ["abc", "bca","dbe"] output : [0,2,1]
    //ex: s= ["zzzz", "ferz", "zdsr", "fgtd"] output: [0,1,3] and [1,3,0]

    public static void main(String[] args) {

        String[] stringArray = {"zzzz", "ferz", "zdsr", "fgtd"};

        Map<Integer, List<Integer>> result = findPositionAndIndex(stringArray);
        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static Map<Integer, List<Integer>> findPositionAndIndex(String[] stringArray) {
        Map<Integer, List<Integer>> finalTempResult = new HashMap<>();
        int mapKey = 0;
        for (int i =0; i < stringArray.length; i++) {
            String firstString = stringArray[i];
            for (int j = i+1 ; j < stringArray.length; j++) {
                String secondString = stringArray[j];
                String index = compareAndFindIndex(firstString, secondString);
                if (index != null) {
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(i);
                    tempResult.add(j);
                    tempResult.add(Integer.parseInt(index));

                    finalTempResult.put(mapKey, tempResult);
                    mapKey = mapKey+1;
                }
            }
        }
        return finalTempResult;
    }

    private static String compareAndFindIndex(String firstString, String secondString) {
        String[] firstStringArray = firstString.split("");
        String[] secondStringArray = secondString.split("");
        for (int i =0; i < firstStringArray.length; i++) {
            if (firstStringArray[i].equalsIgnoreCase(secondStringArray[i])) {
                return String.valueOf(i);
            }
        }
        return null;
    }
}
