package io.coffeelessprogrammer.algorithms.sorting;

import io.coffeelessprogrammer.playground.utils.ColorArray;
import io.coffeelessprogrammer.playground.utils.ConsoleColor;

import java.awt.*;
import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {
        if(arr.length == 1) return arr;

        final int middleIndex = arr.length/2;

        return merge(
                sort(Arrays.copyOfRange(arr, 0, middleIndex)),
                sort(Arrays.copyOfRange(arr, middleIndex, arr.length))
        );
    }

    private static int[] merge(int[] left, int[] right) {
        final int[] merged = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex;

        for (mergedIndex=0; leftIndex < left.length && rightIndex < right.length; ++mergedIndex) {
            if(left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                ++leftIndex;
            } else {
                merged[mergedIndex] = right[rightIndex];
                ++rightIndex;
            }
        }

        if(leftIndex == left.length) {
            System.arraycopy(right, rightIndex, merged, mergedIndex, right.length-rightIndex);
        } else {
            System.arraycopy(left, leftIndex, merged, mergedIndex, left.length-leftIndex);
        }

        return merged;
    }

    // #region ShowSteps

    private static int depth = 0;

    public static int[] sortShowSteps(int[] arr) {
        if(arr.length == 1) return arr;

        final int middleIndex = arr.length/2;

        System.out.printf("\n%sPre-Merge: %s\n",
            "\t".repeat(depth),
            Arrays.toString(arr)
        );

        ++depth;

        return mergeShowSteps(
                sortShowSteps(Arrays.copyOfRange(arr, 0, middleIndex)),
                sortShowSteps(Arrays.copyOfRange(arr, middleIndex, arr.length))
        );
    }

    public static int[] mergeShowSteps(int[] left, int[] right) {
        StringBuilder sb = new StringBuilder("[");

        ConsoleColor leftColor = ConsoleColor.RED;
        ConsoleColor rightColor = ConsoleColor.CYAN;

        final int[] merged = new int[left.length + right.length];

        System.out.printf("%sLeft: %s\n%sRight: %s\n",
            "\t".repeat(depth),
            ColorArray.highlightRange(left, leftColor),
            "\t".repeat(depth),
            ColorArray.highlightRange(right, rightColor)
        );

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex;

        for (mergedIndex=0; leftIndex < left.length && rightIndex < right.length; ++mergedIndex) {
            if(left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                sb.append(leftColor + Integer.toString(left[leftIndex]));
                ++leftIndex;
            } else {
                merged[mergedIndex] = right[rightIndex];
                sb.append(rightColor + Integer.toString(right[rightIndex]));
                ++rightIndex;
            }

            sb.append(", ");
        }

        // System.out.printf("\tMerge In Progress: %s\n", Arrays.toString(merged));

        if(leftIndex == left.length) {
            System.arraycopy(right, rightIndex, merged, mergedIndex, right.length-rightIndex);
            sb.append(rightColor);

            for(int i=rightIndex; i < right.length; ++i) {
                sb.append(right[i]);
                if (i < right.length-1) sb.append(", ");
            }
        } else {
            System.arraycopy(left, leftIndex, merged, mergedIndex, left.length-leftIndex);
            sb.append(leftColor);

            for(int i=leftIndex; i < left.length; ++i) {
                sb.append(left[i]);
                if (i < left.length-1) sb.append(", ");
            }
        }

        sb.append(ConsoleColor.RESET + "]");

        System.out.printf("%sMerge Complete: %s\n\n", "\t".repeat(depth), sb.toString());

        --depth;

        return merged;
    }

    private static String highlightShifted(int[] arr, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder("[");

        for (int i=0; i < arr.length; ++i) {
            if(i == startIndex) sb.append(ConsoleColor.YELLOW);

            if(i == startIndex-1) {
                sb.append('X'); // Insert a placeholder before the shift
            } else {
                sb.append(arr[i]);
            }

            if(i < arr.length-1) sb.append(", ");

            if(i == endIndex) sb.append(ConsoleColor.RESET);
        }

        return sb.append(']').toString();
    }

    // #endRegion
}
