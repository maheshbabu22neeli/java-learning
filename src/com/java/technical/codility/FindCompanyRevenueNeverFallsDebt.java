package com.java.technical.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindCompanyRevenueNeverFallsDebt {

    public int solution(int[] A) {
        List<Integer> negativeExpenses = new ArrayList<>();
        int relocations = 0;
        long currentBalance = 0;

        for (int x : A) {
            currentBalance += x;
            if (x < 0) {
                negativeExpenses.add(x);
            }

            while (currentBalance < 0) {
                int minVal = 0;
                int minIndex = -1;
                for (int i = 0; i < negativeExpenses.size(); i++) {
                    if (negativeExpenses.get(i) < minVal) {
                        minVal = negativeExpenses.get(i);
                        minIndex = i;
                    }
                }

                if (minIndex != -1) {
                    // Remove the minimum value and update balance/relocations
                    negativeExpenses.remove(minIndex);
                    currentBalance -= minVal;
                    relocations++;
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
        System.out.println(sol.solution(A1)); // 1

    }

}
