package dev.coffeelessprogrammer.dsalgo.algorithms;

import dev.coffeelessprogrammer.dsalgo.algorithms.sorting.InsertionSort;
import dev.coffeelessprogrammer.dsalgo.algorithms.sorting.MergeSort;
import dev.coffeelessprogrammer.dsalgo.algorithms.sorting.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingBenchmark {
    private static final Random rand = new Random();

    @Test
    final void ComparativeAlgoBenchmark() {

        final int algoCount = 4;
        final int numIterationsPerSize = 5;
        final int[] arrSizes = { 1000, 2000, 4000, 7000, 10_000, 20_000 };


        /* Insertion Sort (Classic) = [0][][]
         * Insertion Sort (Modified) = [1][][]
         * Quicksort = [2][][]
         * Merge Sort = [3][][]
         */
        final long[][][] sortTimes = new long[algoCount][arrSizes.length][numIterationsPerSize];

        for(int i=0; i < arrSizes.length; ++i) {
            long[][] times = benchmarkComparativeSorts(arrSizes[i], numIterationsPerSize);

            for(int j=0; j<algoCount; ++j) {
                sortTimes[j][i] = times[j];
            }
        }

        displaySortTimes(sortTimes, arrSizes);
    }

    // #region Helpers

    private long[][] benchmarkComparativeSorts(int arraySize, int iterations) {
        long startTime, endTime;

        final int algoCount = 4;

        final long[][] sortTimes = new long[algoCount][iterations];

        for(int i=0; i < iterations; ++i) {
            final int[] arr = rand.ints(arraySize, 0, 10000000).toArray();

            int[] clone = arr.clone();
            assertFalse(isSorted(clone));
            startTime = System.currentTimeMillis();
            InsertionSort.sort(clone);
            endTime = System.currentTimeMillis();
            assertTrue(isSorted(clone));
            sortTimes[0][i] = endTime-startTime;

            clone = arr.clone();
            assertFalse(isSorted(clone));
            startTime = System.currentTimeMillis();
            InsertionSort.insertionSortCoffeeless(clone);
            endTime = System.currentTimeMillis();
            assertTrue(isSorted(clone));
            sortTimes[1][i] = endTime-startTime;

            clone = arr.clone();
            assertFalse(isSorted(clone));
            startTime = System.currentTimeMillis();
            QuickSort.sort(clone);
            endTime = System.currentTimeMillis();
            assertTrue(isSorted(clone));
            sortTimes[2][i] = endTime-startTime;

            clone = arr.clone();
            assertFalse(isSorted(clone));
            startTime = System.currentTimeMillis();
            clone = MergeSort.sort(clone);
            endTime = System.currentTimeMillis();
            assertTrue(isSorted(clone));
            sortTimes[3][i] = endTime-startTime;
        }

        return sortTimes;
    }

    private static void displaySortTimes(long[][][] sortTimes, int[] arraySizes) {
        final int mid = sortTimes[0][0].length/2;
        final int iterations = sortTimes[0][0].length;

        StringBuilder sb = new StringBuilder(1024);

        sb.append("----- Classic Insertion Sort -----\n");
        for(int i=0; i<arraySizes.length; ++i) {
            sb.append("Size ").append(String.format("%,.0f", (float) arraySizes[i])).append(": ");
            sb.append(Arrays.toString(sortTimes[0][i])).append(", ");
            InsertionSort.sort(sortTimes[0][i]);
            sb.append(String.format("mean=%.2f, median=%dms\n", Arrays.stream(sortTimes[0][i]).average().getAsDouble(), sortTimes[0][i][mid]));
        }

        sb.append("\n\n----- Coffeeless Insertion Sort -----\n");
        for(int i=0; i<arraySizes.length; ++i) {
            sb.append("Size ").append(String.format("%,.0f", (float) arraySizes[i])).append(": ");
            sb.append(Arrays.toString(sortTimes[1][i])).append(", ");
            InsertionSort.sort(sortTimes[1][i]);
            sb.append(String.format("mean=%.2f, median=%dms\n", Arrays.stream(sortTimes[1][i]).average().getAsDouble(), sortTimes[1][i][mid]));
        }

        sb.append("\n\n----- Quicksort -----\n");
        for(int i=0; i<arraySizes.length; ++i) {
            sb.append("Size ").append(String.format("%,.0f", (float) arraySizes[i])).append(": ");
            sb.append(Arrays.toString(sortTimes[2][i])).append(", ");
            InsertionSort.sort(sortTimes[2][i]);
            sb.append(String.format("mean=%.2f, median=%dms\n", Arrays.stream(sortTimes[2][i]).average().getAsDouble(), sortTimes[2][i][mid]));
        }

        sb.append("\n\n----- Merge Sort -----\n");
        for(int i=0; i<arraySizes.length; ++i) {
            sb.append("Size ").append(String.format("%,.0f", (float) arraySizes[i])).append(": ");
            sb.append(Arrays.toString(sortTimes[3][i])).append(", ");
            InsertionSort.sort(sortTimes[3][i]);
            sb.append(String.format("mean=%.2f, median=%dms\n", Arrays.stream(sortTimes[3][i]).average().getAsDouble(), sortTimes[3][i][mid]));
        }

        System.out.println(sb.toString());
    }

    private static boolean isSorted(int[] arr) {
        for (int i=0; i < arr.length-1; ++i)
            if(arr[i+1] < arr[i]) return false;

        return true;
    }

    // #endRegion
}
