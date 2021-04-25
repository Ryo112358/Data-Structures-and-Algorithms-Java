package io.coffeelessprogrammer.algorithms.sorting;

import io.coffeelessprogrammer.playground.utils.ConsoleColor;
import io.coffeelessprogrammer.playground.utils.ColorArray;

import java.util.Arrays;


public class InsertionSort implements ShowSteps {

    public static void sort(int[] elements) {
        int currentElement;

        for(int i=1; i < elements.length; ++i) {
            currentElement = elements[i];

            for(int j=0; j < i; ++j) {
                if(currentElement < elements[j]) {
                    System.arraycopy(elements, j, elements, j + 1, i - j);
                    elements[j] = currentElement;
                    break;
                }
            }
        }
    }

    // #region ShowSteps

    public int[] showSteps(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        
        int currentElement;

        System.out.printf("\nUnsorted Array: %s\n\n", Arrays.toString(arrCopy));

        for(int i=1; i < arrCopy.length; ++i) {
            currentElement = arrCopy[i];

            System.out.println("Step " + i + ": " + ColorArray.highlightFocusedElement(arrCopy, i));

            for(int j=0; j < i; ++j) {
                if(currentElement < arrCopy[j]) {

                    System.arraycopy(arrCopy, j, arrCopy, j + 1, i - j);

                    System.out.println("\tShift: " + highlightShifted(arrCopy, j+1, i));

                    arrCopy[j] = currentElement;
                    break;
                }
            }

            System.out.println("\tSorted: " + ColorArray.highlightRange(arrCopy, 0, i));
        }

        System.out.println("\nResult: " + Arrays.toString(arrCopy));

        return arrCopy;
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
