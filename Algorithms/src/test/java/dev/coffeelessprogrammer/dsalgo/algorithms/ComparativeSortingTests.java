package dev.coffeelessprogrammer.dsalgo.algorithms;

import dev.coffeelessprogrammer.dsalgo.algorithms.sorting.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;


class ComparativeSortingTests {

    private final int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};
    private final int[] arr2 = {32, 8, 17, 94, 52, 43, 28, 6, 61};
    private final int[] arr3 = {32, 8, 128, 64, 2, 256, 16, 1, 4};

    @Test
    final void SortArray_Display_InsertionSort() {
        ShowSteps insertionSort = new InsertionSort();

        insertionSort.showSteps(new int[]{4,0,2,8,1});
        System.out.printf("\n\n---------- %s Step-by-Step ----------\n", SortName.INSERTION_SORT);
        insertionSort.showSteps(arr3);
        System.out.printf("\n\n---------- %s Step-by-Step ----------\n", SortName.INSERTION_SORT);
        insertionSort.showSteps(arr1);
        System.out.printf("\n\n---------- %s Step-by-Step ----------\n", SortName.INSERTION_SORT);
        insertionSort.showSteps(arr2);
    }

    @Test
    final void SortArray_Algo_InsertionSort() {
        int[] arr1 = Arrays.copyOf(this.arr1, this.arr1.length);
        int[] arr2 = Arrays.copyOf(this.arr2, this.arr2.length);

        InsertionSort.sort(arr1);
        InsertionSort.sort(arr2);

        System.out.println("Insertion Sort: " + Arrays.toString(arr1));
        System.out.println("Insertion Sort: " + Arrays.toString(arr2));

        assertTrue(isSorted(arr1));
        assertTrue(isSorted(arr2));
    }

    @Test
    final void SortArray_Algo_MergeSort() {
        int[] arr1 = Arrays.copyOf(this.arr1, this.arr1.length);
        int[] arr2 = Arrays.copyOf(this.arr2, this.arr2.length);

        arr1 = MergeSort.sort(arr1);
        arr2 = MergeSort.sort(arr2);
        System.out.println("Merge Sort: " + Arrays.toString(arr1));
        System.out.println("Merge Sort: " + Arrays.toString(arr2));

        assertTrue(isSorted(arr1));
        assertTrue(isSorted(arr2));
    }

    @Test
    final void SortArray_Algo_QuickSort() {
        int[] arr1 = Arrays.copyOf(this.arr1, this.arr1.length);
        int[] arr2 = Arrays.copyOf(this.arr2, this.arr2.length);

        QuickSort.sort(arr1);
        QuickSort.sort(arr2);
        System.out.println("Quicksort: " + Arrays.toString(arr1));
        System.out.println("Quicksort: " + Arrays.toString(arr2));

        assertTrue(isSorted(arr1));
        assertTrue(isSorted(arr2));
    }

    // #region Helpers

    private static boolean isSorted(int[] arr) {
        for (int i=0; i < arr.length-1; ++i) {
            if(arr[i+1] < arr[i]) return false;
        }
        return true;
    }

    // #endRegion
}
