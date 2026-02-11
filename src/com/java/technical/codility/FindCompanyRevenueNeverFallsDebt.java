package com.java.technical.codility;

import java.util.ArrayList;
import java.util.List;

public class FindCompanyRevenueNeverFallsDebt {

    public int solution(int[] A) {
        List<Integer> negativeExpenses = new ArrayList<>();
        int relocations = 0;
        long currentBalance = 0;

        for (int eachAmount : A) {
            currentBalance += eachAmount;
            if (eachAmount < 0) {
                negativeExpenses.add(eachAmount);
            }

            // verify current balance is negative
            while (currentBalance < 0) {
                int minVal = 0;      // assuming minimum value is 0
                int minIndex = -1;   // assuming minimum index is -1 to avoid the confusion of change in index while looping
                for (int i = 0; i < negativeExpenses.size(); i++) {
                    // finding the highest negative amount
                    if (negativeExpenses.get(i) < minVal) {
                        minVal = negativeExpenses.get(i);
                        minIndex = i;
                    }
                }

                // if index got changed removed the value of that index and adjust the balance by subtract the amount
                if (minIndex != -1) {
                    // Remove the minimum value from negative list and adjust the balance.
                    negativeExpenses.remove(minIndex);
                    currentBalance -= minVal;
                    relocations++;  // increase the count.
                }
            }
        }

        return relocations;
    }

    // Test
    public static void main(String[] args) {
        FindCompanyRevenueNeverFallsDebt sol = new FindCompanyRevenueNeverFallsDebt();

        //int[] A1 = {10, -10, -1, -1, 10};
        //System.out.println(sol.solution(A1)); // 1

        int[] A1 = {-1, -1, -1, 1, 10, 3, -1};
        System.out.println(sol.solution(A1)); // 3

        //int[] A1 = {5, -2, -3, 1};
       // System.out.println(sol.solution(A1)); // 0

    }

}
