package dev.coffeelessprogrammer.dsalgo.algorithms;

import dev.coffeelessprogrammer.dsalgo.algorithms.sorting.*;

import java.util.Random;

public class HelloSorting {

    public static void run() {
        System.out.println("Hello Algorithms!");

        Random rand = new Random(System.currentTimeMillis());

        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6, 61};

        final int[] arrRand1 = rand.ints(16, 0, 100).toArray();
        final int[] arrRand2 = rand.ints(35, 0, 1000).toArray();

        displaySortSteps(arr1, SortName.INSERTION_SORT);
//        displaySortSteps(arrRand1, SortName.MERGE_SORT);
//        displaySortSteps(arrRand2, SortName.MERGE_SORT);
//        displaySortSteps(arr1, SortName.QUICKSORT);
//        displaySortSteps(arr1, null);
    }

    private static void displaySortSteps(int[] arrToSort, SortName sortName) {
        System.out.printf("\n\n---------- %s Step-by-Step ----------\n", sortName);

        ShowSteps sort;

        switch (sortName) {
            case INSERTION_SORT:
                sort = new InsertionSort();
                break;
            case MERGE_SORT:
                sort = new MergeSort();
                break;
            default:
                sort = new QuickSort();
        }

        sort.showSteps(arrToSort);
    }
}
