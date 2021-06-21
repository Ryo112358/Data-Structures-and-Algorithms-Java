package io.coffeelessprogrammer.algorithms;

import io.coffeelessprogrammer.algorithms.sorting.InsertionSort;
import io.coffeelessprogrammer.algorithms.sorting.MergeSort;
import io.coffeelessprogrammer.algorithms.sorting.QuickSort;

import static io.coffeelessprogrammer.playground.utils.General.isSorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;


class SortingTests {

    private final int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};
    private final int[] arr2 = {32, 8, 17, 94, 52, 43, 28, 6, 61};

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

    // #endRegion
}
