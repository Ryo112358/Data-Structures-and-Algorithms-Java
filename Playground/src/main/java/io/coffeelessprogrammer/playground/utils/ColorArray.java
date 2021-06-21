package io.coffeelessprogrammer.playground.utils;

import static io.coffeelessprogrammer.playground.utils.General.isSorted;

public class ColorArray {

    // #region HighlightSingleElement

    public static String highlightElement(int[] arr, int highlightIndex) {
        return highlightElement(arr, highlightIndex, ConsoleColor.BLUE);
    }

    public static String highlightElement(int[] arr, int highlightIndex, ConsoleColor consoleColor) {
        StringBuilder sb = new StringBuilder("[");

        for (int i=0; i < arr.length; ++i) {
            if(i == highlightIndex) sb.append(consoleColor);

            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");

            if(i == highlightIndex) sb.append(ConsoleColor.RESET);
        }

        return sb.append(']').toString();
    }

    // #endRegion

    // #region HighlightMultipleElements

    public static String highlightElements(int[] arr, ConsoleColor color, int... indices) {
        if(!isHighlightElementsInputValid(arr, indices)) return null;

        StringBuilder sb = new StringBuilder("[");

        int coloredCount = 0;

        for (int i=0; i < arr.length; ++i) {
            if(i == indices[coloredCount]) sb.append(color);

            sb.append(arr[i]);

            if(i < arr.length-1) sb.append(", ");

            if(i == indices[coloredCount]){
                sb.append(ConsoleColor.RESET);
                ++coloredCount;
                if (coloredCount == indices.length) break;
            }
        }

        for (int i = indices[indices.length-1]+1; i < arr.length; ++i) {
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }

        return sb.append(']').toString();
    }

    public static String highlightElements(int[] arr, ConsoleColor[] colors, int... indices) {
        if(!isHighlightElementsInputValid(arr, indices, colors)) return null;

        StringBuilder sb = new StringBuilder("[");

        int coloredCount = 0;

        for (int i=0; i < arr.length; ++i) {
            if(i == indices[coloredCount]) sb.append(colors[coloredCount]);

            sb.append(arr[i]);

            if(i < arr.length-1) sb.append(", ");

            if(i == indices[coloredCount]){
                sb.append(ConsoleColor.RESET);
                ++coloredCount;
                if (coloredCount == indices.length) break;
            }
        }

        for (int i = indices[indices.length-1]+1; i < arr.length; ++i) {
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }

        return sb.append(']').toString();
    }

    private static boolean isHighlightElementsInputValid(int[] arr, int[] indices) {
        if(arr==null || indices==null) {
            throw new IllegalArgumentException("One of the required parameters is null.");
        }
        if(!isSorted(indices)) {
            throw new IllegalArgumentException("Indices must be in ordered from low to high.");
        }
        for (int i=1; i < indices.length; ++i) {
            if(indices[i] == indices[i-1]) {
                throw new IllegalArgumentException("Indices to highlight must be unique.");
            }
        }

        return true;
    }

    private static boolean isHighlightElementsInputValid(int[] arr, int[] indices, ConsoleColor[] colors) {
        if(colors==null) {
            throw new IllegalArgumentException("The colors parameter is null.");
        }

        return isHighlightElementsInputValid(arr, indices);
    }

    // #endRegion

    // #region HighlightSingleSection

    public static String highlightArray(int[] arr) {
        return highlightRange(arr, 0, arr.length-1, ConsoleColor.GREEN);
    }

    public static String highlightArray(int[] arr, ConsoleColor consoleColor) {
        return highlightRange(arr, 0, arr.length-1, consoleColor);
    }

    public static String highlightRange(int[] arr, int startIndex, int endIndex) {
        return highlightRange(arr, startIndex, endIndex, ConsoleColor.GREEN);
    }

    public static String highlightRange(int[] arr, int startIndex, int endIndex, ConsoleColor consoleColor) {
        if(!isHighlightRangeInputValid(arr, startIndex, endIndex)) return null;

        StringBuilder sb = new StringBuilder("[");

        for (int i=0; i < arr.length; ++i) {
            if(i == startIndex) sb.append(consoleColor);

            sb.append(arr[i]);

            if(i < arr.length-1) sb.append(", ");

            if(i == endIndex) sb.append(ConsoleColor.RESET);
        }

        return sb.append(']').toString();
    }

    private static boolean isHighlightRangeInputValid(int[] arr, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            throw new IllegalArgumentException("Start index must be lower than the ending index.");
        }
        if(startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Both the start and end indices must be non-negative.");
        }

        return true;
    }

    // #endRegion

    // #region HighlightMultipleSections

    public static String highlightRanges(int[] arr, int[][] ranges, ConsoleColor[] colors) {
        if(!isHighlightRangesInputValid(arr, ranges, colors)) return null;


        StringBuilder sb = new StringBuilder("[");

        int coloredCount = 0;

        for (int i=0; i < arr.length; ++i) {
            if(i == ranges[coloredCount][0]) sb.append(colors[coloredCount]);

            sb.append(arr[i]);

            if(i < arr.length-1) sb.append(", ");

            if(i == ranges[coloredCount][1]){
                sb.append(ConsoleColor.RESET);
                ++coloredCount;
                if (coloredCount == ranges.length) break;
            }
        }

        for (int i = ranges[ranges.length-1][1]+1; i < arr.length; ++i) {
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }

        return sb.append(']').toString();
    }

    private static boolean isHighlightRangesInputValid(int[] arr, int[][] ranges, ConsoleColor[] colors) {
        if(arr==null || ranges==null || colors==null) {
            throw new IllegalArgumentException("One of the required parameters is null.");
        }
        if(colors.length != ranges.length) {
            throw new IllegalArgumentException("The number of colors must match the number of ranges to color.");
        }
        if(ranges[0].length != 2) {
            throw new IllegalArgumentException("Ranges must have a starting and ending index only.");
        }
        if(ranges[ranges.length-1][1] > arr.length-1 || ranges[0][0] < 0) {
            throw new IllegalArgumentException("All ranges must be within the bounds of the array length.");
        }
        for (int i=1; i < ranges.length; ++i) {
            if(ranges[i-1][1] >= ranges[i][0]) {
                throw new IllegalArgumentException("Ranges to highlight must not overlap.");
            }
        }

        return true;
    }

    // #endRegion

}
