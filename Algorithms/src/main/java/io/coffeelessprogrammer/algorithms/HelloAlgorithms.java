package io.coffeelessprogrammer.algorithms;

import io.coffeelessprogrammer.algorithms.sorting.InsertionSort;

public class HelloAlgorithms {

    public static void main(String[] args) {
        System.out.println("Hello Algorithms!");

        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        InsertionSort.sortShowSteps(arr1);
    }
}
