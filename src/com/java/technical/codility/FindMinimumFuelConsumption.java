package com.java.technical.codility;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumFuelConsumption {

    private static final int SEATS = 5;
    private long fuel = 0;
    private List<List<Integer>> roads;

    public static void main(String[] args) {
        FindMinimumFuelConsumption findMinimumFuelConsumption = new FindMinimumFuelConsumption();
        int[] A;
        int[] B;

        A = new int[]{1,1,1,9,9,9,9,7,8};
        B = new int[]{2,0,3,1,6,5,4,0,0};
        System.out.println(findMinimumFuelConsumption.solution(A, B));
    }


    public int solution(int[] A, int[] B) {
        int n = A.length; // number of roads

        roads = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }

        //  A = new int[]{1,1,1,9,9,9,9,7,8};
        //  B = new int[]{2,0,3,1,6,5,4,0,0};
        for (int i = 0; i < n; i++) {
            roads.get(A[i]).add(B[i]);
            roads.get(B[i]).add(A[i]);
        }

        System.out.println();

        // assuming that there is no parent, hence started with -1
        findParentAndChildPaths(0, -1);

        return (int) fuel;
    }


    private int findParentAndChildPaths(int node, int parent) {

        int people = (node == 0) ? 0 : 1;

        for (int next : roads.get(node)) {

            if (next == parent) {
                continue;
            }

            // go for recursive
            int childPeople = findParentAndChildPaths(next, node);

            // Find the cars
            long cars = (childPeople + SEATS - 1) / SEATS;
            fuel = fuel +  cars;

            // add people
            people = people + childPeople;
        }

        return people;
    }
}
