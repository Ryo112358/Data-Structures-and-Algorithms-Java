package io.coffeelessprogrammer.algorithms;

import io.coffeelessprogrammer.algorithms.sorting.InsertionSort;
import io.coffeelessprogrammer.algorithms.sorting.MergeSort;
import io.coffeelessprogrammer.algorithms.sorting.ShowSteps;
import io.coffeelessprogrammer.algorithms.sorting.SortName;

import java.util.Random;


public class HelloAlgorithms {

    public static void main(String[] args) {
        System.out.println("Hello Algorithms!");

        Random rand = new Random(System.currentTimeMillis());

        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6, 61};

        final int[] arrRand1 = rand.ints(16, 0, 100).toArray();
        final int[] arrRand2 = rand.ints(35, 0, 1000).toArray();

        displaySortSteps(arr1, SortName.INSERTION_SORT);
        displaySortSteps(arrRand1, SortName.MERGE_SORT);
        displaySortSteps(arrRand2, SortName.MERGE_SORT);
    }

    private static void displaySortSteps(int[] arrToSort, SortName sortName) {
        System.out.printf("\n\n---------- %s Example ----------\n", sortName);

        ShowSteps sort;

        switch (sortName) {
            case INSERTION_SORT -> {
                sort = new InsertionSort();
                sort.showSteps(arrToSort);
            }
            case MERGE_SORT -> {
                sort = new MergeSort();
                sort.showSteps(arrToSort);
            }
        }
    }
}
