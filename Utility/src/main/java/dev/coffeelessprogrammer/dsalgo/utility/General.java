package dev.coffeelessprogrammer.dsalgo.utility;

import java.util.Arrays;

public class General {

    public static boolean isSorted(int[] arr) {
        for (int i=0; i < arr.length-1; ++i) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    private static String repeatSymbol(char symbol, int count) {
        char[] arr = new char[count];
        Arrays.fill(arr, symbol);
        return String.valueOf(arr);
    }
}
