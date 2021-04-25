package io.coffeelessprogrammer.algorithms;

import io.coffeelessprogrammer.algorithms.sorting.InsertionSort;
import io.coffeelessprogrammer.algorithms.sorting.MergeSort;

import java.util.Arrays;


public class HelloAlgorithms {

    public static void main(String[] args) {
        System.out.println("Hello Algorithms!");

        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6, 61};

        System.out.println("\n\n---------- Insertion Sort Example ----------");
        InsertionSort.sortShowSteps(Arrays.copyOf(arr1, arr1.length));

        System.out.println("\n\n---------- Merge Sort Example ----------");
        MergeSort.sortShowSteps(Arrays.copyOf(arr1, arr1.length));
    }
}
