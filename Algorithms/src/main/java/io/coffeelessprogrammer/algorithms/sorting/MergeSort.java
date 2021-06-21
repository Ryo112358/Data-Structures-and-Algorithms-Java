package io.coffeelessprogrammer.algorithms.sorting;

import io.coffeelessprogrammer.playground.utils.ColorArray;
import io.coffeelessprogrammer.playground.utils.ConsoleColor;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort implements ShowSteps {

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

    private int depth;
    private ArrayList<Integer> levelCounters;

    private final ConsoleColor preMergeTextColor;
    private final ConsoleColor postMergeTextColor;
    private final ConsoleColor leftArrColor;
    private final ConsoleColor rightArrColor;

    public MergeSort() {
        this.depth = 0;

        this.preMergeTextColor = ConsoleColor.YELLOW;
        this.postMergeTextColor = ConsoleColor.GREEN;
        this.leftArrColor = ConsoleColor.RED;
        this.rightArrColor = ConsoleColor.CYAN;
    }

    public void showSteps(int[] arr) {
        sortShowSteps(arr);
    }

    private int[] sortShowSteps(int[] arr) {
        if(arr.length == 1) return arr;

        // If new array, reset level counters
        if(depth == 0) {
            levelCounters = new ArrayList<>();
        }

        final int middleIndex = arr.length/2;

        if(levelCounters.size() >= depth+1) {
            levelCounters.set(depth, levelCounters.get(depth)+1);
        } else {
            levelCounters.add(1);
        }

        System.out.printf("\n%s%sL%d%s Pre-Merge: %s%s\n",
            "\t".repeat(depth),
            this.preMergeTextColor,
            depth,
            depth==0 ? "" : "." + levelCounters.get(depth),
            ConsoleColor.RESET,
            Arrays.toString(arr)
        );

        ++depth;

        return mergeShowSteps(
                sortShowSteps(Arrays.copyOfRange(arr, 0, middleIndex)),
                sortShowSteps(Arrays.copyOfRange(arr, middleIndex, arr.length))
        );
    }

    private int[] mergeShowSteps(int[] left, int[] right) {
        StringBuilder sb = new StringBuilder("[");

        ConsoleColor leftColor = this.leftArrColor;
        ConsoleColor rightColor = this.rightArrColor;

        final int[] merged = new int[left.length + right.length];

        System.out.printf("%sLeft: %s\n%sRight: %s\n",
            "\t".repeat(depth),
            ColorArray.highlightArray(left, leftColor),
            "\t".repeat(depth),
            ColorArray.highlightArray(right, rightColor)
        );

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex;

        for (mergedIndex=0; leftIndex < left.length && rightIndex < right.length; ++mergedIndex) {
            if(left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                sb.append(leftColor).append(left[leftIndex]);
                ++leftIndex;
            } else {
                merged[mergedIndex] = right[rightIndex];
                sb.append(rightColor).append(right[rightIndex]);
                ++rightIndex;
            }

            sb.append(", ");
        }

        String mergeProgress = appendXs(new StringBuilder(sb), mergedIndex, merged.length);

        System.out.printf("%sMerging... %s\n", "\t".repeat(depth), mergeProgress);

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

        sb.append(ConsoleColor.RESET).append(']');

        System.out.printf("\n%s%sL%d%s Merge Complete: %s%s\n\n",
            "\t".repeat(depth-1),
            this.postMergeTextColor,
            depth-1,
            depth-1==0 ? "" : "." + levelCounters.get(depth-1),
            ConsoleColor.RESET,
            sb
        );

        --depth;

        return merged;
    }

    private String appendXs(StringBuilder sb, int from, int arrayLength) {
        sb.append(ConsoleColor.RESET);

        for (int i=from; i < arrayLength; ++i) {
            sb.append('X');

            if(i < arrayLength-1) sb.append(", ");
        }

        return sb.append(']').toString();
    }

    // #endRegion
}
