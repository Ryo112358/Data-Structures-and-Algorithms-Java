package io.coffeelessprogrammer.algorithms.sorting;

import io.coffeelessprogrammer.playground.utils.ColorArray;
import io.coffeelessprogrammer.playground.utils.ConsoleColor;

import java.util.Arrays;

public class QuickSort implements ShowSteps {

    public static void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int leftBound, int rightBound) {

        final int pivotIndex = rightBound;

        if (leftBound < rightBound) {
            final int partitionIndex = partition(array, pivotIndex, leftBound, rightBound);

            sort(array, leftBound, partitionIndex-1);
            sort(array, partitionIndex+1, rightBound);
        }
    }

    private static int partition(int[] array, int pivotIndex, int leftBound, int rightBound) {
        final int pivotValue = array[pivotIndex];

        int partitionIndex = leftBound;

        for (int i=leftBound; i < rightBound; ++i) {
            if (array[i] < pivotValue) {
                swap(array, i, partitionIndex);
                ++partitionIndex;
            }
        }

        swap(array, rightBound, partitionIndex);

        return partitionIndex;
    }

    // #region Helpers

    private static void swap(int[] array, int pos1, int pos2) {
        final int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    private static void swapNumerical(int[] array, int pos1, int pos2) {
        System.out.println("Before: " + Arrays.toString(array));
        array[pos2] = array[pos2] - array[pos1];
        array[pos1] = array[pos1] + array[pos2];
        array[pos2] = array[pos1] - array[pos2];
        System.out.println("After: " + Arrays.toString(array));
    }

    // #endRegion

    // #region ShowSteps

    private final ConsoleColor[] partitionColors;
    private final ConsoleColor[] swapColors;
    private final ConsoleColor[] partitionColorsFlipped;

    public QuickSort() {
        final ConsoleColor pivotIndexColor = ConsoleColor.RED;
        final ConsoleColor partitionIndexColor = ConsoleColor.YELLOW;
        final ConsoleColor iterationIndexColor = ConsoleColor.BLUE;

        this.partitionColors = new ConsoleColor[]{ partitionIndexColor, pivotIndexColor };
        this.swapColors = new ConsoleColor[]{ partitionIndexColor, iterationIndexColor };
        this.partitionColorsFlipped = new ConsoleColor[]{ pivotIndexColor, partitionIndexColor };
    }

    public void showSteps(int[] array) {
        sortShowSteps(array, 0, array.length-1);
    }

    private void sortShowSteps(int[] array, int leftBound, int rightBound) {

        System.out.println("Sorting Range (" + leftBound + ", " + rightBound + "): " + ColorArray.highlightRange(array, leftBound, rightBound) + "\n");

        final int pivotIndex = rightBound;

        if (leftBound < rightBound) {
            final int partitionIndex = partitionShowSteps(array, pivotIndex, leftBound, rightBound);

            sortShowSteps(array, leftBound, partitionIndex-1);
            sortShowSteps(array, partitionIndex+1, rightBound);
        }

        System.out.println("Status... (" + leftBound + ", " + rightBound + "): " + ColorArray.highlightRange(array, leftBound, rightBound) + "\n");
    }

    private int partitionShowSteps(int[] array, int pivotIndex, int leftBound, int rightBound) {
        final int pivotValue = array[pivotIndex];
        int partitionIndex = leftBound;

        System.out.println("Partitioning... " + ColorArray.highlightElements(array, this.partitionColors, partitionIndex, pivotIndex));

        for (int i=leftBound; i < rightBound; ++i) {
            if (array[i] < pivotValue) {

                if(i == partitionIndex) {
                    System.out.println("\tSwapping... " + ColorArray.highlightElement(array, i, ConsoleColor.GREEN));
                } else {
                    System.out.println("\tSwapping... " + ColorArray.highlightElements(array, this.swapColors, partitionIndex, i));
                }

                swap(array, i, partitionIndex);

                if(i == partitionIndex) {
                    System.out.println("\tSwapped!    " + ColorArray.highlightElement(array, i, ConsoleColor.GREEN));
                } else {
                    System.out.println("\tSwapped!    " + ColorArray.highlightElements(array, this.swapColors, partitionIndex, i));
                }

                ++partitionIndex;
            }
        }

        if(partitionIndex == pivotIndex) {
            System.out.println("Partitioning... " + ColorArray.highlightElement(array, pivotIndex, ConsoleColor.RED_BOLD));
        } else {
            System.out.println("Partitioning... " + ColorArray.highlightElements(array, this.partitionColors, partitionIndex, pivotIndex));
        }

        swap(array, rightBound, partitionIndex);

        if(partitionIndex == pivotIndex) {
            System.out.println("Partitioned!    " + ColorArray.highlightElement(array, pivotIndex, ConsoleColor.RED_BOLD) + "\n");
        } else {
            System.out.println("Partitioned!    " + ColorArray.highlightElements(array, this.partitionColorsFlipped, partitionIndex, pivotIndex) + "\n");
        }

        return partitionIndex;
    }

    // #endRegion

    // #region ShowStepsHelpers

    private int[][] generateRanges(int... singleIndices) {
        final int[][] ranges = new int[singleIndices.length][2];

        for(int i=0; i < singleIndices.length; ++i) {
            ranges[i] = new int[]{ singleIndices[i], singleIndices[i] };
        }
        System.out.println("\t\tGenerated Ranges: " + Arrays.deepToString(ranges));
        return ranges;
    }

    // #endRegion
}
