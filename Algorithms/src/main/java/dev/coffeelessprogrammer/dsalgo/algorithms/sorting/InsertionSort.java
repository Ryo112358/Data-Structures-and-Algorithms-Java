package dev.coffeelessprogrammer.dsalgo.algorithms.sorting;

import dev.coffeelessprogrammer.dsalgo.utility.ColorArray;
import dev.coffeelessprogrammer.dsalgo.utility.ConsoleColor;

import java.util.Arrays;


public class InsertionSort implements ShowSteps {

    public static void sort(int[] arr) {
        int current, j;

        for(int i=1; i < arr.length; ++i) {
            current = arr[i];

            for (j = i - 1; j >= 0 && current < arr[j]; --j)
                arr[j + 1] = arr[j];

            arr[j + 1] = current;
        }
    }

    public static void insertionSortCoffeeless(int[] arr) {
        int current, j;

        for(int i=1; i < arr.length; ++i) {
            current = arr[i];

            j = findInsertPosition(arr, 0, i-1, current);

            System.arraycopy(arr, j, arr, j + 1, i - j);
            arr[j] = current;
        }
    }

    private static int findInsertPosition(int[] nums, int lB, int rB, int target) {
        int mid=(lB+rB)/2;

        while(lB<=rB) {
            mid=(lB+rB)/2;

            if(target < nums[mid]) rB=mid-1;
            else lB = mid+1;
        }

        return target < nums[mid] ? mid : mid+1;
    }

    public static void sort(long[] arr) {
        int j;
        long current;

        for(int i=1; i < arr.length; ++i) {
            current = arr[i];

            for (j = i - 1; j >= 0 && current < arr[j]; --j)
                arr[j + 1] = arr[j];

            arr[j + 1] = current;
        }
    }

    // #region ShowSteps

    public void showSteps(int[] arr) {
        sortShowSteps(Arrays.copyOf(arr, arr.length));
    }

    private void sortShowSteps(int[] arr) {
        
        int currentElement;

        System.out.printf("\nUnsorted Array: %s\n\n", Arrays.toString(arr));

        for(int i=1; i < arr.length; ++i) {
            currentElement = arr[i];

            System.out.println("Step " + i + ": " + ColorArray.highlightElement(arr, i));

            for(int j=0; j < i; ++j) {
                if(currentElement < arr[j]) {

                    System.arraycopy(arr, j, arr, j + 1, i - j);

                    System.out.println("\tShift: " + highlightShifted(arr, j+1, i));

                    arr[j] = currentElement;
                    break;
                }
            }

            System.out.println("\tSorted: " + ColorArray.highlightRange(arr, 0, i));
        }

        System.out.println("\nResult: " + Arrays.toString(arr));
    }

    private String highlightShifted(int[] arr, int startIndex, int endIndex) {
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
