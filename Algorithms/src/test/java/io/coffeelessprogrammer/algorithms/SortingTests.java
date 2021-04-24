package io.coffeelessprogrammer.algorithms;

import io.coffeelessprogrammer.algorithms.sorting.InsertionSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;


class SortingTests {

    private final int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};
    private final int[] arr2 = {32, 8, 17, 94, 52, 43, 28, 6};

    @Test
    final void SortArray_Algo_InsertionSort() {
        int[] arr1 = Arrays.copyOf(this.arr1, this.arr1.length);
        int[] arr2 = Arrays.copyOf(this.arr2, this.arr2.length);

        InsertionSort.sort(arr1);
        InsertionSort.sort(arr2);

        System.out.println("Class: " + Arrays.toString(this.arr1));
        System.out.println("Method: " + Arrays.toString(arr1));

        assertTrue(isSorted(arr1));
        assertTrue(isSorted(arr2));
    }

    // #region Helpers

    private boolean isSorted(int[] arr) {
        for (int i=0; i < arr.length-1; ++i) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    // #endRegion
}
