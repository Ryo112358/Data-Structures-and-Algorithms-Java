package io.coffeelessprogrammer.playground.utils;

public class ColorArray {

    public static String highlightFocusedElement(int[] arr, int highlightIndex) {
        return highlightFocusedElement(arr, highlightIndex, ConsoleColor.BLUE);
    }

    public static String highlightFocusedElement(int[] arr, int highlightIndex, ConsoleColor consoleColor) {
        StringBuilder sb = new StringBuilder("[");

        for (int i=0; i < arr.length; ++i) {
            if(i == highlightIndex) sb.append(consoleColor);

            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");

            if(i == highlightIndex) sb.append(ConsoleColor.RESET);
        }

        return sb.append(']').toString();
    }

    public static String highlightRange(int[] arr) {
        return highlightRange(arr, 0, arr.length-1, ConsoleColor.GREEN);
    }

    public static String highlightRange(int[] arr, ConsoleColor consoleColor) {
        return highlightRange(arr, 0, arr.length-1, consoleColor);
    }

    public static String highlightRange(int[] arr, int startIndex, int endIndex) {
        return highlightRange(arr, startIndex, endIndex, ConsoleColor.GREEN);
    }

    public static String highlightRange(int[] arr, int startIndex, int endIndex, ConsoleColor consoleColor) {
        StringBuilder sb = new StringBuilder("[");

        for (int i=0; i < arr.length; ++i) {
            if(i == startIndex) sb.append(consoleColor);

            sb.append(arr[i]);

            if(i < arr.length-1) sb.append(", ");

            if(i == endIndex) sb.append(ConsoleColor.RESET);
        }

        return sb.append(']').toString();
    }

}
